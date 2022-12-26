package com.android.dayplanner.app

import java.time.LocalDateTime.now
import java.time.format.DateTimeFormatter.ofLocalizedDateTime
import java.time.format.FormatStyle.MEDIUM

fun receiveCurrentDate():String {
    val currentTime = now()
    val formatterDate = ofLocalizedDateTime(MEDIUM)
    return currentTime.format(formatterDate)
}