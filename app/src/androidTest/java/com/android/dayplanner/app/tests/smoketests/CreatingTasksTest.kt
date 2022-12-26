package com.android.dayplanner.app.tests.smoketests

import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.screens.TasksHistoryScreen
import com.android.dayplanner.app.tests.BaseTest
import com.android.dayplanner.app.tests.DataForTests
import com.android.dayplanner.app.tests.scenarios.CreateCustomTaskScenario
import com.android.dayplanner.app.tests.scenarios.CreateLongDummyTaskScenario
import com.android.dayplanner.app.tests.scenarios.CreateShortDummyTaskScenario
import org.junit.Test

class CreatingTasksTest : BaseTest() {

    @Test
    fun checkTasksAreDisplayedOnTheHomeScreen() = run {
        scenario(
            CreateCustomTaskScenario(
                DataForTests.TASK_TITLE1,
                DataForTests.TASK_DESCRIPTION1,
                DataForTests.TASK_DATE1
            )
        )
        step("Check the added task 1 on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(
                    DataForTests.TASK_TITLE1,
                    DataForTests.TASK_DESCRIPTION1,
                    DataForTests.TASK_DATE1
                )
            }
        }
        scenario(
            CreateLongDummyTaskScenario(
                DataForTests.TASK_TITLE2,
                DataForTests.TASK_DESCRIPTION2,
                DataForTests.TASK_DATE2
            )
        )
        step("Check the added task 2 on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(
                    DataForTests.TASK_TITLE2,
                    DataForTests.TASK_DESCRIPTION2,
                    DataForTests.TASK_DATE2
                )
            }
        }
        scenario(
            CreateShortDummyTaskScenario(
                DataForTests.TASK_TITLE3,
                DataForTests.TASK_DESCRIPTION3,
                DataForTests.TASK_DATE3
            )
        )
        step("Check the added task 3 on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(
                    DataForTests.TASK_TITLE3,
                    DataForTests.TASK_DESCRIPTION3,
                    DataForTests.TASK_DATE3
                )
            }
        }
    }

    @Test
    fun checkTasksAreDisplayedOnTheTaskHistoryScreen() = run {
        scenario(
            CreateCustomTaskScenario(
                DataForTests.TASK_TITLE1,
                DataForTests.TASK_DESCRIPTION1,
                DataForTests.TASK_DATE1
            )
        )
        scenario(
            CreateCustomTaskScenario(
                DataForTests.TASK_TITLE2,
                DataForTests.TASK_DESCRIPTION2,
                DataForTests.TASK_DATE2
            )
        )
        scenario(
            CreateCustomTaskScenario(
                DataForTests.TASK_TITLE3,
                DataForTests.TASK_DESCRIPTION3,
                DataForTests.TASK_DATE3
            )
        )
        step("Check complete status of the task 1 on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(DataForTests.TASK_TITLE1)
            }
        }
        step("Check complete status of the task 2 on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(DataForTests.TASK_TITLE2)
            }
        }
        step("Check complete status of the task 3 on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(DataForTests.TASK_TITLE3)
            }
        }
        step("Open the \"TaskHistory\" screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheTasksHistory()
            }
        }
        step("Check the added task 1 on the \"TaskHistory\" screen") {
            TasksHistoryScreen {
                assertTaskAddedInTheTaskHistory(
                    DataForTests.TASK_TITLE1,
                    DataForTests.TASK_DESCRIPTION1,
                    DataForTests.TASK_DATE1
                )
            }
        }
        step("Check the added task 2 on the \"TaskHistory\" screen") {
            TasksHistoryScreen {
                assertTaskAddedInTheTaskHistory(
                    DataForTests.TASK_TITLE2,
                    DataForTests.TASK_DESCRIPTION2,
                    DataForTests.TASK_DATE2
                )
            }
        }
        step("Check the added task 3 on the \"TaskHistory\" screen") {
            TasksHistoryScreen {
                assertTaskAddedInTheTaskHistory(
                    DataForTests.TASK_TITLE3,
                    DataForTests.TASK_DESCRIPTION3,
                    DataForTests.TASK_DATE3
                )
            }
        }
    }
}