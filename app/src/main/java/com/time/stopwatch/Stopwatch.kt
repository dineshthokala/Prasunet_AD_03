package com.time.stopwatch

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.*

class Stopwatch {

    var timeElapsed by mutableStateOf(0L)
        private set

    var isRunning by mutableStateOf(false)
        private set

    var formattedTime by mutableStateOf("00:00:00.000")
        private set

    private var timer: Timer? = null

    fun start() {
        if (!isRunning) {
            isRunning = true
            timer = Timer()
            timer?.scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    timeElapsed += 10
                    updateFormattedTime()
                }
            }, 0, 10)
        }
    }

    fun pause() {
        timer?.cancel()
        timer = null
        isRunning = false
    }

    fun reset() {
        pause()
        timeElapsed = 0L
        updateFormattedTime()
    }

    private fun updateFormattedTime() {
        val hours = (timeElapsed / 3600000).toInt()
        val minutes = ((timeElapsed % 3600000) / 60000).toInt()
        val seconds = ((timeElapsed % 60000) / 1000).toInt()
        val milliseconds = (timeElapsed % 1000).toInt()
        formattedTime = String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds)
    }
}
