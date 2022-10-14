package com.android.dayplanner.app.screens

import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import com.android.dayplanner.app.R
import com.android.dayplanner.app.screens.ListOfTasksBasic.RecyclerOfTasks
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import junit.framework.AssertionFailedError

class HomeScreen : Screen<HomeScreen>(), ListOfTasksBasic {

    private val fabTaskButton = KButton { withId(R.id.floating_action_button) }
    private val showTaskHistoryView = KView { withText(R.string.label_history) }
    private val recyclerViewOfTasks = KRecyclerView({
        withId(R.id.recyclerView)
    }, itemTypeBuilder = {
        itemType(::RecyclerOfTasks)
    })
    private val deleteAllTaskView = KView { withText(R.string.label_delete_all) }
    private val yesView = KView { withText(R.string.yes) }
    private val backgroundMainImageView = KImageView { withId(R.id.imageView) }
    private val backgroundMainTextView = KTextView { withId(R.id.textView) }

    fun actionClickOnFabTaskButton() {
        fabTaskButton.click()
    }

    fun actionDeleteTheTask(textTitle: String) {
        actionClickONDeleteButton(recyclerViewOfTasks, textTitle)
    }

    fun actionEditTheTask(textTitle: String) {
        actionClickOnTheTask(recyclerViewOfTasks, textTitle)
    }

    fun actionClickOnCompleteTheTask(textTitle: String) {
        actionClickOnCheckBox(recyclerViewOfTasks, textTitle)
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
        assertTheTaskIsNotInTheList(recyclerViewOfTasks, textTitle)
    }

    fun assertTaskAddedInTheList(textTitle: String, textDescription: String, date: String) {
        assertTheTaskIsInTheList(recyclerViewOfTasks, textTitle, textDescription, date)
    }

    fun assertTheListIsEmpty(): Boolean {
        if (recyclerViewOfTasks.getSize() == 0) return true
        else
            throw AssertionFailedError("The list is not empty.")
    }

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