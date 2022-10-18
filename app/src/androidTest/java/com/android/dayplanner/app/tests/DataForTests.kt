package com.android.dayplanner.app.tests

import com.android.dayplanner.app.receiveCurrentDate

object DataForTests {

    const val TASK_TITLE = "Create new tests"
    const val TASK_TITLE_NEW = "Edit tests"
    const val TASK_DESCRIPTION = "Need to use Kakao framework"
    val TASK_DATE = receiveCurrentDate()
    val START_DATE = TASK_DATE
}