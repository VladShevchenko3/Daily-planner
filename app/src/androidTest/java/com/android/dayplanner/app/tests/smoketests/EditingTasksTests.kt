package com.android.dayplanner.app.tests.smoketests

import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.screens.TasksHistoryScreen
import com.android.dayplanner.app.tests.BaseTest
import com.android.dayplanner.app.tests.DataForTests
import com.android.dayplanner.app.tests.scenarios.CreateCustomTaskScenario
import com.android.dayplanner.app.tests.scenarios.CreateLongDummyTaskScenario
import com.android.dayplanner.app.tests.scenarios.CreateShortDummyTaskScenario
import com.android.dayplanner.app.tests.scenarios.EditTaskScenario
import org.junit.Test

class EditingTasksTests : BaseTest() {

    @Test
    fun checkTheAbilityToEditTasksOnTheHomeScreen() = run {
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
        step("Edit the task 1 on the \"Home\" screen") {
            HomeScreen {
                actionEditTheTask(DataForTests.TASK_TITLE1)
            }
        }
        scenario(
            EditTaskScenario(
                DataForTests.EDIT_TASK_TITLE1,
                DataForTests.EDIT_TASK_DESCRIPTION1,
                DataForTests.EDIT_TASK_DATE1
            )
        )
        step("Check the modify task 1 is displayed on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(
                    DataForTests.EDIT_TASK_TITLE1,
                    DataForTests.EDIT_TASK_DESCRIPTION1,
                    DataForTests.EDIT_TASK_DATE1
                )
            }
        }
        step("Edit the task2 on the \"Home\" screen") {
            HomeScreen {
                actionEditTheTask(DataForTests.TASK_TITLE2)
            }
        }
        scenario(
            EditTaskScenario(
                DataForTests.EDIT_TASK_TITLE2,
                DataForTests.EDIT_TASK_DESCRIPTION2,
                DataForTests.EDIT_TASK_DATE2
            )
        )
        step("Check the modify task 2 is displayed on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(
                    DataForTests.EDIT_TASK_TITLE2,
                    DataForTests.EDIT_TASK_DESCRIPTION2,
                    DataForTests.EDIT_TASK_DATE2
                )
            }
        }
        step("Edit the task 3 on the \"Home\" screen") {
            HomeScreen {
                actionEditTheTask(DataForTests.TASK_TITLE3)
            }
        }
        scenario(
            EditTaskScenario(
                DataForTests.EDIT_TASK_TITLE3,
                DataForTests.EDIT_TASK_DESCRIPTION3,
                DataForTests.EDIT_TASK_DATE3
            )
        )
        step("Check the modify task 3 is displayed on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(
                    DataForTests.EDIT_TASK_TITLE3,
                    DataForTests.EDIT_TASK_DESCRIPTION3,
                    DataForTests.EDIT_TASK_DATE3
                )
            }
        }
    }

    @Test
    fun checkTheAbilityToEditTasksOnTheTaskHistoryScreen() = run {
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
        step("Edit the task 1 on the \"TaskHistory\" screen") {
            TasksHistoryScreen {
                actionEditTheTask(DataForTests.TASK_TITLE1)
            }
        }
        scenario(
            EditTaskScenario(
                DataForTests.EDIT_TASK_TITLE1,
                DataForTests.EDIT_TASK_DESCRIPTION1,
                DataForTests.EDIT_TASK_DATE1
            )
        )
        step("Check the modify task 1 is displayed on the \"TaskHistory\" screen") {
            TasksHistoryScreen {
                assertTaskAddedInTheTaskHistory(
                    DataForTests.EDIT_TASK_TITLE1,
                    DataForTests.EDIT_TASK_DESCRIPTION1,
                    DataForTests.EDIT_TASK_DATE1
                )
            }
        }
        step("Edit the task 2 on the \"TaskHistory\" screen") {
            TasksHistoryScreen {
                actionEditTheTask(DataForTests.TASK_TITLE2)
            }
        }
        scenario(
            EditTaskScenario(
                DataForTests.EDIT_TASK_TITLE2,
                DataForTests.EDIT_TASK_DESCRIPTION2,
                DataForTests.EDIT_TASK_DATE2
            )
        )
        step("Check the modify task 2 is displayed on the \"TaskHistory\" screen") {
            TasksHistoryScreen {
                assertTaskAddedInTheTaskHistory(
                    DataForTests.EDIT_TASK_TITLE2,
                    DataForTests.EDIT_TASK_DESCRIPTION2,
                    DataForTests.EDIT_TASK_DATE2
                )
            }
        }
        step("Edit the task 3 on the \"TaskHistory\" screen") {
            TasksHistoryScreen {
                actionEditTheTask(DataForTests.TASK_TITLE3)
            }
        }
        scenario(
            EditTaskScenario(
                DataForTests.EDIT_TASK_TITLE3,
                DataForTests.EDIT_TASK_DESCRIPTION3,
                DataForTests.EDIT_TASK_DATE3
            )
        )
        step("Check the modify task 3 is displayed on the \"TaskHistory\" screen") {
            TasksHistoryScreen {
                assertTaskAddedInTheTaskHistory(
                    DataForTests.EDIT_TASK_TITLE3,
                    DataForTests.EDIT_TASK_DESCRIPTION3,
                    DataForTests.EDIT_TASK_DATE3
                )
            }
        }
    }
}