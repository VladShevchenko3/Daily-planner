package com.android.dayplanner.app.tests

import com.android.dayplanner.app.screens.EmptyTaskListScreen
import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.screens.NewTaskScreen
import com.android.dayplanner.app.screens.TasksHistoryScreen
import com.android.dayplanner.app.tests.DataForTests.EDIT_TASK_TITLE1
import com.android.dayplanner.app.tests.DataForTests.TASK_DATE1
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION1
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE1
import org.junit.Test

class TestsForTasksList : BaseTest() {

    @Test
    fun checkCreatingAndDeletingTheTask() = run {
        step("Open the \"Home\" screen and click the fab button") {
            HomeScreen {
                actionClickOnFabTaskButton()
            }
        }
        step("Enter the task title, description, data and save the task on the \"HewTask\" screen") {
            NewTaskScreen {
                actionEditTextTitle(TASK_TITLE1)
                actionEditTextDescription(TASK_DESCRIPTION1)
                actionEditTextData(TASK_DATE1)
                actionClickOnSaveButton()
            }
        }
        step("Check the added task on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(TASK_TITLE1, TASK_DESCRIPTION1, TASK_DATE1)
            }
        }
        step(" Delete the created task on the \"Home\" screen") {
            HomeScreen {
                actionDeleteTheTask(TASK_TITLE1)
            }
        }
        step(" Check the task not displayed on the \"Home\" screen") {
            HomeScreen {
                assertTheTaskIsNotDisplayed(TASK_TITLE1)
            }
        }
    }

    @Test
    fun checkEditingTheTaskInList() = run {
        step("Open the \"Home\" screen and click the fab button") {
            HomeScreen {
                actionClickOnFabTaskButton()
            }
        }
        step("Enter the task title, description, data and save the task on the \"HewTask\" screen") {
            NewTaskScreen {
                actionEditTextTitle(TASK_TITLE1)
                actionEditTextDescription(TASK_DESCRIPTION1)
                actionEditTextData(TASK_DATE1)
                actionClickOnSaveButton()
            }
        }
        step("Edit the task on the \"Home\" screen") {
            HomeScreen {
                actionEditTheTask(TASK_TITLE1)
            }
        }
        step("Change the title of the task and save the task on the \"HewTask\" screen") {
            NewTaskScreen {
                actionEditTextTitle(EDIT_TASK_TITLE1)
                actionClickOnSaveButton()
            }
        }
        step("Check the modify task is displayed on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(EDIT_TASK_TITLE1, TASK_DESCRIPTION1, TASK_DATE1)
            }
        }
        step("Delete all tasks on the \"Home\" screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheDeleteAllTasks()
                actionClickOnYesButton()
            }
        }
        step("Check the list is empty") {
            HomeScreen {
                assertTheListIsEmpty()
            }
        }
        step("Check the image and text are displayed") {
            EmptyTaskListScreen {
                assertBackgroundImageIsVisible()
                assertBackgroundTextIsVisible()
            }
        }
    }

    @Test
    fun checkArchivingOfTasks() = run {
        step("Open the \"Home\" screen and click the fab button") {
            HomeScreen {
                actionClickOnFabTaskButton()
            }
        }
        step("Enter the task title, description, data and save the task on the \"HewTask\" screen") {
            NewTaskScreen {
                actionEditTextTitle(TASK_TITLE1)
                actionEditTextDescription(TASK_DESCRIPTION1)
                actionEditTextData(TASK_DATE1)
                actionClickOnSaveButton()
            }
        }
        step("Complete the task on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(TASK_TITLE1)
            }
        }
        step("Open the \"TaskHistory\" screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheTasksHistory()
            }
        }
        step(
            "Check the complete status of the task, uncheck complete status " +
                    "and press back on the \"TaskHistory\" screen"
        ) {
            TasksHistoryScreen {
                assertTheStatusOfTaskIsChecked(TASK_TITLE1)
                actionUncheckTheTaskStatus(TASK_TITLE1)
                actionPressBack()
            }
        }
        step("Check the task is displayed on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(TASK_TITLE1, TASK_DESCRIPTION1, TASK_DATE1)
            }
        }
    }
}