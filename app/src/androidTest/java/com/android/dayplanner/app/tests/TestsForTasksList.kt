package com.android.dayplanner.app.tests

import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.screens.NewTaskScreen
import com.android.dayplanner.app.screens.TasksHistoryScreen
import com.android.dayplanner.app.tests.DataForTests.START_DATE
import com.android.dayplanner.app.tests.DataForTests.TASK_DATA
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE_EXTRA1
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE_EXTRA2
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE_EXTRA3
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE_EXTRA4
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE_EXTRA5
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE_EXTRA6
import io.github.kakaocup.kakao.screen.Screen.Companion.onScreen
import org.junit.Test

class TestsForTasksList : SetUp() {

    /*
     * Scenario
     * Step 1. Add new task;
     * Step 2. Enter task title;
     * Step 3. Enter task description;
     * Step 4. Enter task data;
     * Step 5. Click 'Save';
     * Step 6. Check the added task;
     * Step 7. Delete the created task;
     * Step 8. Check the task not displayed;
     */
    @Test
    fun checkAddingAndDeletingNewTask() {
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<NewTaskScreen> {
            actionEditTextTitle(TASK_TITLE)
            actionEditTextDescription(TASK_DESCRIPTION)
            actionEditTextData(TASK_DATA)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            assertTaskAddedInTheList(TASK_TITLE, TASK_DESCRIPTION, START_DATE)
            actionDeleteTheTask(TASK_TITLE)
            assertTheTaskIsNotDisplayed(TASK_TITLE)
        }
    }

    /*
     * Scenario
     * Step 1. Add new task;
     * Step 2. Enter task title;
     * Step 3. Enter task description;
     * Step 4. Enter task data;
     * Step 5. Click 'Save';
     * Step 6. Mark the task as completed;
     * Step 7. Open the toolbar;
     * Step 8. Click 'Show Tasks History';
     * Step 9. Mark the task as not completed;
     * Step 9. Check the task not displayed;
     * Step 10. Press Back;
     * Step 11. Check the task is displayed;
     */
    @Test
    fun checkArchivingOfTasks() {
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<NewTaskScreen> {
            actionEditTextTitle(TASK_TITLE)
            actionEditTextDescription(TASK_DESCRIPTION)
            actionEditTextData(TASK_DATA)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnCompleteTheTask(TASK_TITLE)
            actionOpensTheOverflowMenu()
            actionClickOnTheTasksHistory()
        }
        onScreen<TasksHistoryScreen> {
            actionClickOnCompleteTaskButton(TASK_TITLE)
            actionPressBack()
        }
        onScreen<HomeScreen> {
            assertTaskAddedInTheList(TASK_TITLE, TASK_DESCRIPTION, TASK_DATA)
        }
    }

    /*
     * Scenario
     * Step 1. Add new task;
     * Step 2. Enter task title;
     * Step 3. Enter task description;
     * Step 4. Enter task data;
     * Step 5. Click 'Save';
     * Step 6. Repeat steps 1 to 5  four times;
     * Step 7. Edit the last task;
     * Step 6. Edit task title;
     * Step 7. Click 'Save';
     * Step 8. Check the modify task is displayed;
     * Step 7. Open the toolbar;
     * Step 8. Click 'Delete All Tasks';
     * Step 9. Click 'Yes' on the dialog;
     * Step 10. Check the list is empty
     */
    @Test
    fun checkFindingAndEditingATaskInList() {
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<NewTaskScreen> {
            actionEditTextTitle(TASK_TITLE)
            actionEditTextDescription(TASK_DESCRIPTION)
            actionEditTextData(TASK_DATA)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<NewTaskScreen> {
            actionEditTextTitle(TASK_TITLE_EXTRA1)
            actionEditTextDescription(TASK_DESCRIPTION)
            actionEditTextData(TASK_DATA)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<NewTaskScreen> {
            actionEditTextTitle(TASK_TITLE_EXTRA2)
            actionEditTextDescription(TASK_DESCRIPTION)
            actionEditTextData(TASK_DATA)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<NewTaskScreen> {
            actionEditTextTitle(TASK_TITLE_EXTRA3)
            actionEditTextDescription(TASK_DESCRIPTION)
            actionEditTextData(TASK_DATA)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<NewTaskScreen> {
            actionEditTextTitle(TASK_TITLE_EXTRA4)
            actionEditTextDescription(TASK_DESCRIPTION)
            actionEditTextData(TASK_DATA)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<NewTaskScreen> {
            actionEditTextTitle(TASK_TITLE_EXTRA5)
            actionEditTextDescription(TASK_DESCRIPTION)
            actionEditTextData(TASK_DATA)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionEditTheTask(TASK_TITLE_EXTRA1)
        }
        onScreen<NewTaskScreen> {
            actionEditTextTitle(TASK_TITLE_EXTRA6)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            assertTaskAddedInTheList(TASK_TITLE_EXTRA6, TASK_DESCRIPTION, TASK_DATA)
            actionOpensTheOverflowMenu()
            actionClickOnTheDeleteAllTasks()
            actionClickOnYesButton()
            assertTheListIsEmpty()
        }
    }

    /*
     * Scenario
     * Step 1. Check the background image is displayed;
     * Step 2. Check tha background text is displayed;
     * Step 3. Add new task;
     * Step 4. Enter task title;
     * Step 5. Enter task description;
     * Step 6. Enter task data;
     * Step 7. Click 'Save';
     * Step 8. Check the background image is not displayed;
     * Step 9. Check tha background text is not displayed;
     */
    @Test
    fun checkBackgroundImageAndTextDisappears() {
        onScreen<HomeScreen> {
            assertBackgroundImageIsVisible()
            assertBackgroundTextIsVisible()
            actionClickOnFabTaskButton()
        }
        onScreen<NewTaskScreen> {
            actionEditTextTitle(TASK_TITLE)
            actionEditTextDescription(TASK_DESCRIPTION)
            actionEditTextData(TASK_DATA)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            assertBackgroundImageIsNotVisible()
            assertBackgroundTextIsNotVisible()
        }
    }
}