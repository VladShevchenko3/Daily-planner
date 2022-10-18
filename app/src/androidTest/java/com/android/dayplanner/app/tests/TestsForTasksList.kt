package com.android.dayplanner.app.tests

import com.android.dayplanner.app.screens.EmptyTaskListScreen
import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.screens.NewTaskScreen
import com.android.dayplanner.app.screens.TasksHistoryScreen
import com.android.dayplanner.app.tests.DataForTests.START_DATE
import com.android.dayplanner.app.tests.DataForTests.TASK_DATE
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE_NEW
import org.junit.Test


class TestsForTasksList : BaseTest() {

    @Test
    fun checkAddingAndDeletingTheTask() = run {
        step("Open \"Home\" screen and click fab button") {
            HomeScreen {
                actionClickOnFabTaskButton()
            }
        }
        step("Enter the task title, description, data and save the task on \"HewTask\" screen") {
            NewTaskScreen {
                actionEditTextTitle(TASK_TITLE)
                actionEditTextDescription(TASK_DESCRIPTION)
                actionEditTextData(TASK_DATE)
                actionClickOnSaveButton()
            }
        }
        step("Check the added task on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(TASK_TITLE, TASK_DESCRIPTION, START_DATE)
            }
        }
        step(" Delete the created task on the \"Home\" screen") {
            HomeScreen {
                actionDeleteTheTask(TASK_TITLE)
            }
        }
        step(" Check the task not displayed on the \"Home\" screen") {
            HomeScreen {
                assertTheTaskIsNotDisplayed(TASK_TITLE)
            }
        }
    }

    @Test
    fun checkEditingTheTaskInList() = run {
        step("Open \"Home\" screen and click fab button") {
            HomeScreen {
                actionClickOnFabTaskButton()
            }
        }
        step("Enter the task title, description, data and save the task on \"HewTask\" screen") {
            NewTaskScreen {
                actionEditTextTitle(TASK_TITLE)
                actionEditTextDescription(TASK_DESCRIPTION)
                actionEditTextData(TASK_DATE)
                actionClickOnSaveButton()
            }
        }
        step("Edit the task on \"Home\" screen") {
            HomeScreen {
                actionEditTheTask(TASK_TITLE)
            }
        }
        step("Change the task title and save the task on \"HewTask\" screen") {
            NewTaskScreen {
                actionEditTextTitle(TASK_TITLE_NEW)
                actionClickOnSaveButton()
            }
        }
        step("Check the modify task is displayed on \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(TASK_TITLE_NEW, TASK_DESCRIPTION, TASK_DATE)
            }
        }
        step("Delete all tasks on \"Home\" screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheDeleteAllTasks()
                actionClickOnYesButton()
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
        step("Open \"Home\" screen and click fab button") {
            HomeScreen {
                actionClickOnFabTaskButton()
            }
        }
        step("Enter the task title, description, data and save the task on \"HewTask\" screen") {
            NewTaskScreen {
                actionEditTextTitle(TASK_TITLE)
                actionEditTextDescription(TASK_DESCRIPTION)
                actionEditTextData(TASK_DATE)
                actionClickOnSaveButton()
            }
        }
        step("Complete the task on \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(TASK_TITLE)
            }
        }
        step("Open \"TaskHistory\" screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheTasksHistory()
            }
        }
        step(
            "Check the complete status of the task, uncheck complete status " +
                    "and press back on \"TaskHistory\" screen"
        ) {
            TasksHistoryScreen {
                assertTheStatusOfTaskIsChecked(TASK_TITLE)
                actionUncheckTheTaskStatus(TASK_TITLE)
                actionPressBack()
            }
        }
        step("Check the task is displayed on \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(TASK_TITLE, TASK_DESCRIPTION, TASK_DATE)
            }
        }
    }
}