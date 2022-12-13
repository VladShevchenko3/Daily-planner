package com.android.dayplanner.app.tests.smoketests

import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.screens.TasksHistoryScreen
import com.android.dayplanner.app.tests.BaseTest
import com.android.dayplanner.app.tests.DataForTests.TASK_DATE1
import com.android.dayplanner.app.tests.DataForTests.TASK_DATE2
import com.android.dayplanner.app.tests.DataForTests.TASK_DATE3
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION1
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION2
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION3
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE1
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE2
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE3
import com.android.dayplanner.app.tests.scenarios.CreateCustomTaskScenario
import com.android.dayplanner.app.tests.scenarios.CreateLongDummyTaskScenario
import com.android.dayplanner.app.tests.scenarios.CreateShortDummyTaskScenario
import org.junit.Test

class CheckBoxTest : BaseTest() {

    @Test
    fun checkCheckBoxStatus() = run {
        scenario(CreateCustomTaskScenario(TASK_TITLE1, TASK_DESCRIPTION1, TASK_DATE1))
        scenario(CreateLongDummyTaskScenario(TASK_TITLE2, TASK_DESCRIPTION2, TASK_DATE2))
        scenario(CreateShortDummyTaskScenario(TASK_TITLE3, TASK_DESCRIPTION3, TASK_DATE3))

        step("Click on checked for all tasks on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(TASK_TITLE1)
                actionClickOnCompleteTheTask(TASK_TITLE2)
                actionClickOnCompleteTheTask(TASK_TITLE3)
                actionOpensTheOverflowMenu()
                actionClickOnTheTasksHistory()
            }
        }
        step("Check status of custom task and uncheck them all on the \"History\" screen") {
            TasksHistoryScreen {
                assertTheStatusOfTaskIsChecked(TASK_TITLE1)
                assertTheStatusOfTaskIsChecked(TASK_TITLE2)
                assertTheStatusOfTaskIsChecked(TASK_TITLE3)
                actionUncheckTheTaskStatus(TASK_TITLE1)
                actionUncheckTheTaskStatus(TASK_TITLE2)
                actionUncheckTheTaskStatus(TASK_TITLE3)
                actionPressBack()
            }
        }
        step("Check status of all tasks & uncheck them all on the \"Home\" screen") {
            HomeScreen {
                assertTheStatusOfTaskIsNotChecked(TASK_TITLE1)
                assertTheStatusOfTaskIsNotChecked(TASK_TITLE2)
                assertTheStatusOfTaskIsNotChecked(TASK_TITLE3)
            }
        }
    }
}