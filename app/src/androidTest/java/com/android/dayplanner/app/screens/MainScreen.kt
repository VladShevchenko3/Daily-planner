package com.android.dayplanner.app.screens

import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import com.android.dayplanner.app.R
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

class MainScreen : Screen<MainScreen>() {

    private val fabTaskButton = KButton { withId(R.id.floating_action_button) }
    private val showTaskHistoryView = KView { withText(R.string.label_history) }
    private val recyclerView = KRecyclerView({
        withId(R.id.recyclerView)
    }, itemTypeBuilder = {
        itemType(::ListOfTaskFragment)
    })
    private val deleteAllTaskView = KView { withText(R.string.label_delete_all) }
    private val yesView = KView { withText(R.string.yes) }
    private val noView = KView { withText(R.string.no) }
    private val backgroundMainImageView = KImageView { withId(R.id.imageView) }
    private val backgroundMainTextView = KTextView { withId(R.id.textView) }

    fun actionClickOnFabTaskButton() {
        fabTaskButton.click()
    }

    fun actionDeleteTheTask(textTitle: String) {
        recyclerView {
            childWith<ListOfTaskFragment> {
                withDescendant { withText(textTitle) }
            } perform {
                deleteTaskButton.click()
            }
        }
    }

    fun actionEditTheTask(textTitle: String) {
        recyclerView {
            childWith<ListOfTaskFragment> {
                withDescendant { withText(textTitle) }
            } perform {
                titleTextField.click()
            }
        }
    }

    fun actionClickOnCompleteTheTask(textTitle: String) {
        recyclerView {
            childWith<ListOfTaskFragment> {
                withDescendant { withText(textTitle) }
            } perform {
                completeTaskCheckBox.click()
            }
        }
    }

    fun actionOpensTheOverflowMenu() {
        openContextualActionModeOverflowMenu()
    }

    fun actionClickOnTheDeleteAllTasks() {
        deleteAllTaskView.click()
    }

    fun actionClickOnYesButton() {
        yesView.click()
    }

    fun actionClickOnTheTasksHistory() {
        showTaskHistoryView.click()
    }

    fun assertTheTaskIsNotDisplayed(textTitle: String) {
        recyclerView {
            childWith<ListOfTaskFragment> {
                withDescendant { withText(textTitle) }
            } perform {
                doesNotExist()
            }
        }
    }

    fun assertTaskAddedInTheList(textTitle: String, textDescription: String, date: String) {
        recyclerView {
            childWith<ListOfTaskFragment> {
                withDescendant { withText(textTitle) }
            } perform {
                descriptionTextField.hasText(textDescription)
                dateTextField.hasText(date)
            }
        }
    }

    fun assertTheListIsEmpty() = recyclerView.getSize() == 0

    fun assertBackgroundImageIsVisible() {
        backgroundMainImageView.isVisible()
    }

    fun assertBackgroundImageIsNotVisible() {
        backgroundMainImageView.isNotDisplayed()
    }

    fun assertBackgroundTextIsVisible() {
        backgroundMainTextView.hasText(R.string.no_tasks)
    }

    fun assertBackgroundTextIsNotVisible() {
        backgroundMainTextView.isNotDisplayed()
    }
}