package com.time.stopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Pause
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.scale
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.time.stopwatch.ui.theme.*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StopwatchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface
                ) {
                    val systemUiController = rememberSystemUiController()
                    val statusBarColor = MaterialTheme.colors.surface
                    val navigationBarColor = MaterialTheme.colors.onSurface
                    val barIcons = isSystemInDarkTheme()

                    SideEffect {
                        systemUiController.setNavigationBarColor(
                            color = navigationBarColor,
                            darkIcons = barIcons
                        )
                        systemUiController.setStatusBarColor(
                            color = statusBarColor,
                            darkIcons = true
                        )
                    }
                    val stopWatch = remember { Stopwatch() }
                    StopwatchTimer(
                        formattedTime = stopWatch.formattedTime,
                        onStartClick = stopWatch::start,
                        onPauseClick = stopWatch::pause,
                        onResetClick = stopWatch::reset
                    )
                }
            }
        }
    }
}

@Composable
fun StopwatchTimer(
    formattedTime: String,
    onStartClick: () -> Unit,
    onPauseClick: () -> Unit,
    onResetClick: () -> Unit,
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ) {
            TopAppBar(
                title = {
                    Text(
                        text = "Stopwatch",
                        color = Text
                    )
                },
                backgroundColor = ButtonBackground
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = formattedTime,
                    fontWeight = FontWeight.Bold,
                    fontSize = 50.sp,
                    color = Text
                )
            }
            Spacer(Modifier.height(100.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FloatingActionButton(
                    onClick = onStartClick,
                    backgroundColor = ButtonBackground,
                    contentColor = ButtonIcons
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Outlined.PlayArrow,
                        contentDescription = "Start stopwatch"
                    )
                }
                FloatingActionButton(
                    onClick = onPauseClick,
                    backgroundColor = ButtonBackground,
                    contentColor = ButtonIcons
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Outlined.Pause,
                        contentDescription = "Pause stopwatch"
                    )
                }
                FloatingActionButton(
                    onClick = onResetClick,
                    backgroundColor = ButtonBackground,
                    contentColor = ButtonIcons
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Outlined.Clear,
                        contentDescription = "Reset stopwatch"
                    )
                }
            }
        }
    }
}
//change 1