package com.android.dayplanner.app.tests

import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.screens.NewTaskScreen
import com.android.dayplanner.app.tests.DataForTests.DATE
import com.android.dayplanner.app.tests.DataForTests.START_DATE
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE
import io.github.kakaocup.kakao.screen.Screen.Companion.onScreen
import org.junit.Test

class TestsForTasksList : BaseTest() {

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
    fun checkAddingAndDeletingNewTaskNew() = run {
        step("Open \"Home\" screen and click fab button") {
            HomeScreen {
                actionClickOnFabTaskButton() }
        }
        step("Enter task title, description data and save the task on \"HewTask\" screen  ") {
            NewTaskScreen {
                actionEditTextTitle(TASK_TITLE)
                actionEditTextDescription(TASK_DESCRIPTION)
                actionEditTextData(DATE)
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
    fun checkBackgroundImageAndTextDisappears() = run {
        step("Check the background image is displayed") {
            onScreen<HomeScreen> {
                assertBackgroundImageIsVisible()
            }
        }
        step("Check the background text is displayed") {
            onScreen<HomeScreen> {
                assertBackgroundTextIsVisible()
            }
        }
        step("Add new task") {
            onScreen<HomeScreen> {
                actionClickOnFabTaskButton()
            }
        }
        step("Enter task title") {
            onScreen<NewTaskScreen> {
                actionEditTextTitle(TASK_TITLE)
            }
        }
        step("Enter task description") {
            onScreen<NewTaskScreen> {
                actionEditTextDescription(TASK_DESCRIPTION)
            }
        }
        step("Enter task data") {
            onScreen<NewTaskScreen> {
                actionEditTextData(DATE)
            }
        }
        step("Click on 'Save'") {
            onScreen<NewTaskScreen> {
                actionClickOnSaveButton()
            }
        }
        step("Check the background image is not displayed") {
            onScreen<HomeScreen> {
                assertBackgroundImageIsNotVisible()
            }
        }
        step("Check the background text is not displayed") {
            onScreen<HomeScreen> {
                flakySafely(5000) {
                    assertBackgroundTextIsNotVisible()
                }
            }
        }
    }
}