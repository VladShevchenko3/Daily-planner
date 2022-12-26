package com.android.dayplanner.app.tests

import androidx.test.core.app.ActivityScenario
import com.android.dayplanner.app.ui.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.After
import org.junit.Before

open class BaseTest : TestCase() {

    lateinit var activityScenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        if (this::activityScenario.isInitialized) {
            activityScenario.close()
        }
    }
}