/*
 * Copyright 2024 KDW03
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.najudoryeong.mineme.feature.story.util

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.exifinterface.media.ExifInterface
import java.io.IOException
import java.util.Locale

fun readImageMetadata(
    uri: Uri,
    context: Context,
    updateDate: (Int, Int, Int) -> Unit,
    updateLocation: (String, String) -> Unit,
) {
    try {
        context.contentResolver.openInputStream(uri)?.use { inputStream ->
            val exifInterface = ExifInterface(inputStream)

            exifInterface.getAttribute(ExifInterface.TAG_DATETIME)?.let { dateString ->
                val parts = dateString.split(" ")[0].split(":")
                if (parts.size == 3) {
                    updateDate(parts[0].toInt(), parts[1].toInt(), parts[2].toInt())
                }
            }

            val latitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE)
            val latitudeRef = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE_REF)
            val longitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE)
            val longitudeRef = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF)
            Log.d("Error[KDW]", "Latitude raw data: $latitude, Ref: $latitudeRef")
            Log.d("Error[KDW]", "Longitude raw data: $longitude, Ref: $longitudeRef")

            val lat = convertToDegree(latitude, latitudeRef)
            val lon = convertToDegree(longitude, longitudeRef)

            Log.d("Error[KDW]", "$lat , $lon")
            if (lat != null && lon != null) {
                getAddressFromLocation(lat, lon, context, updateLocation)
            }
        }
    } catch (e: IOException) {
        Log.e("Error[KDW]", "Error reading image metadata", e)
    }
}

fun convertToDegree(gpsInfo: String?, ref: String?): Double? {
    gpsInfo?.let {
        val parts = it.split(",").map { part ->
            val dms = part.split("/").map(String::trim)
            dms[0].toDouble() / dms[1].toDouble()
        }

        if (parts.size == 3) {
            var degree = parts[0] + (parts[1] / 60.0) + (parts[2] / 3600.0)
            if (ref == "S" || ref == "W") {
                degree = -degree
            }
            return degree
        }
    }
    return null
}

fun getAddressFromLocation(
    latitude: Double,
    longitude: Double,
    context: Context,
    updateLocation: (String, String) -> Unit,
) {
    val geocoder = Geocoder(context, Locale.getDefault())

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val listener = object : Geocoder.GeocodeListener {
            override fun onGeocode(addresses: MutableList<Address>) {
                Log.d("Error[KDW]", addresses.joinToString(" "))
                if (addresses.isNotEmpty()) {
                    val address = addresses[0]
                    val region = address.adminArea
                    val city = address.locality
                    if (region != null && city != null) updateLocation(region, city)
                }
            }

            override fun onError(errorMessage: String?) {
                Log.d("Error[KDW]", "Geocoding failed with error: $errorMessage")
            }
        }
        geocoder.getFromLocation(latitude, longitude, 1, listener)
    } else {
        val addresses = geocoder.getFromLocation(latitude, longitude, 1)
        if (addresses != null) {
            if (addresses.isNotEmpty()) {
                val address = addresses[0]
                val region = address.adminArea
                val city = address.locality
                if (region != null && city != null) updateLocation(region, city)
            }
        }
    }
}
