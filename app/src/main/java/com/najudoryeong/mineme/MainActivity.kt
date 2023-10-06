package com.najudoryeong.mineme

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.najudoryeong.mineme.core.data.util.NetworkMonitor
import com.najudoryeong.mineme.core.designsystem.theme.DoTheme
import com.najudoryeong.mineme.core.ui.MainActivityUiState
import com.najudoryeong.mineme.ui.DoApp
import com.najudoryeong.mineme.ui.SignUpApp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        var uiState: MainActivityUiState by mutableStateOf(MainActivityUiState.Loading)


        //detect benchmarking
        val isBenchmarking = applicationContext.packageName.endsWith(".benchmark")
        if (isBenchmarking) viewModel.updateJWT("test_jwt")


        // ui state 수집
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState
                    .onEach {
                        uiState = it
                    }
                    .collect()
            }
        }

        // uiState에 따른 splash 구현
        splashScreen.setKeepOnScreenCondition {
            when (uiState) {
                MainActivityUiState.Loading -> true
                is MainActivityUiState.Success -> false
            }
        }


        // 화면을 전체 화면 모드로 설정하므로 콘텐츠가 화면의 모든 가장자리까지 확장
        // 이는 상태 표시줄 및 탐색 표시줄과 같은 시스템 UI가 콘텐츠 아래에 나타나도록

        // 전체 화면 모드를 활성화
        enableEdgeToEdge()


        setContent {
            DoTheme(
                darkTheme = false,
                androidTheme = false,
                disableDynamicTheming = false,
            ) {
                when (uiState) {
                    MainActivityUiState.Loading -> Unit
                    is MainActivityUiState.Success -> {
                        if ((uiState as MainActivityUiState.Success).userData.jwt.isEmpty()) {
                            SignUpApp(updateJwt = viewModel::updateJWT)
                        } else {
                            DoApp(
                                networkMonitor = networkMonitor,
                                windowSizeClass = calculateWindowSizeClass(this@MainActivity)
                            )
                        }
                    }
                }
            }
        }
    }
}

