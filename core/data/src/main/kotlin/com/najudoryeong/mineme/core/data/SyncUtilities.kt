package com.najudoryeong.mineme.core.data



interface Synchronizer {

    suspend fun Syncable.sync() = this@sync.syncWith(this@Synchronizer)
}


// 원격 네트워크와 로컬 데이터베이스를 동기화
interface Syncable {
    suspend fun syncWith(synchronizer: Synchronizer): Boolean
}
