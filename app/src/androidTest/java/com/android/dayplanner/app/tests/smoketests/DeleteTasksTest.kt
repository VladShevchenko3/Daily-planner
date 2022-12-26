package com.android.dayplanner.app.tests.smoketests

import com.android.dayplanner.app.screens.EmptyTaskListScreen
import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.screens.TasksHistoryScreen
import com.android.dayplanner.app.tests.BaseTest
import com.android.dayplanner.app.tests.DataForTests
import com.android.dayplanner.app.tests.scenarios.CreateCustomTaskScenario
import com.android.dayplanner.app.tests.scenarios.CreateLongDummyTaskScenario
import com.android.dayplanner.app.tests.scenarios.CreateShortDummyTaskScenario
import com.android.dayplanner.app.tests.scenarios.DeleteTaskByTitle
import org.junit.Test

class DeleteTasksTest : BaseTest() {
    @Test
    fun checkDeleteTasksByToolbar() = run {
        scenario(
            CreateCustomTaskScenario(
                DataForTests.TASK_TITLE1,
                DataForTests.TASK_DESCRIPTION1,
                DataForTests.TASK_DATE1
            )
        )
        scenario(
            CreateLongDummyTaskScenario(
                DataForTests.TASK_TITLE2,
                DataForTests.TASK_DESCRIPTION2,
                DataForTests.TASK_DATE2
            )
        )
        scenario(
            CreateShortDummyTaskScenario(
                DataForTests.TASK_TITLE3,
                DataForTests.TASK_DESCRIPTION3,
                DataForTests.TASK_DATE3
            )
        )

        step("Delete all tasks wih toolBar on \"Home\" screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheDeleteAllTasks()
                actionClickOnYesButton()
                assertTaskIsNotPresentOnScreen(DataForTests.TASK_TITLE1)
                assertTaskIsNotPresentOnScreen(DataForTests.TASK_TITLE2)
                assertTaskIsNotPresentOnScreen(DataForTests.TASK_TITLE3)
            }
        }
    }

    @Test
    fun deleteTasksByButton() = run {
        scenario(
            CreateCustomTaskScenario(
                DataForTests.TASK_TITLE1,
                DataForTests.TASK_DESCRIPTION1,
                DataForTests.TASK_DATE1
            )
        )
        scenario(
            CreateLongDummyTaskScenario(
                DataForTests.TASK_TITLE2,
                DataForTests.TASK_DESCRIPTION2,
                DataForTests.TASK_DATE2
            )
        )
        scenario(
            CreateShortDummyTaskScenario(
                DataForTests.TASK_TITLE3,
                DataForTests.TASK_DESCRIPTION3,
                DataForTests.TASK_DATE3
            )
        )

        scenario(DeleteTaskByTitle(DataForTests.TASK_TITLE1))
        scenario(DeleteTaskByTitle(DataForTests.TASK_TITLE2))
        scenario(DeleteTaskByTitle(DataForTests.TASK_TITLE3))

        step("Go to Tasks History Screen screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheTasksHistory()
            }
        }
        step("check is not tasks present on \"TasksHistoryScreen\"") {
            TasksHistoryScreen {
                assertTaskIsNotPresentOnScreen(DataForTests.TASK_TITLE1)
                assertTaskIsNotPresentOnScreen(DataForTests.TASK_TITLE2)
                assertTaskIsNotPresentOnScreen(DataForTests.TASK_TITLE3)
            }
        }
    }

    @Test
    fun deleteTasksAndCheckEmptyScreen() = run {
        scenario(
            CreateCustomTaskScenario(
                DataForTests.TASK_TITLE1,
                DataForTests.TASK_DESCRIPTION1,
                DataForTests.TASK_DATE1
            )
        )
        scenario(
            CreateLongDummyTaskScenario(
                DataForTests.TASK_TITLE2,
                DataForTests.TASK_DESCRIPTION2,
                DataForTests.TASK_DATE2
            )
        )
        scenario(
            CreateShortDummyTaskScenario(
                DataForTests.TASK_TITLE3,
                DataForTests.TASK_DESCRIPTION3,
                DataForTests.TASK_DATE3
            )
        )

        step("go to Tasks History Screen screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheTasksHistory()
            }
        }

        scenario(DeleteTaskByTitle(DataForTests.TASK_TITLE1))
        scenario(DeleteTaskByTitle(DataForTests.TASK_TITLE2))
        scenario(DeleteTaskByTitle(DataForTests.TASK_TITLE3))

        step("back to Main screen") {
            TasksHistoryScreen {
                pressBack()
            }
        }

        step("check is empty screen is present") {
            EmptyTaskListScreen {
                assertBackgroundImageIsVisible()
                assertBackgroundTextIsVisible()
            }
        }
    }
}