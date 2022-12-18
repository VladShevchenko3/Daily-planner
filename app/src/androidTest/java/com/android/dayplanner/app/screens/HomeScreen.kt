package com.android.dayplanner.app.screens

import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import com.android.dayplanner.app.R
import com.android.dayplanner.app.screens.ListOfTasksBasic.TaskItem
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

class HomeScreen : Screen<HomeScreen>(), ListOfTasksBasic {

    private val fabTaskButton = KButton { withId(R.id.floating_action_button) }
    private val showTaskHistoryView = KView { withText(R.string.label_history) }
    private val taskItemsView = KRecyclerView({
        withId(R.id.recyclerView)
    }, itemTypeBuilder = {
        itemType(::TaskItem)
    })
    private val deleteAllTaskView = KView { withText(R.string.label_delete_all) }
    private val yesView = KView { withText(R.string.yes) }
    private val backgroundMainImageView = KImageView { withId(R.id.imageView) }
    private val backgroundMainTextView = KTextView { withId(R.id.textView) }

    fun actionClickOnFabTaskButton() {
        fabTaskButton.click()
    }

    fun actionDeleteTheTask(textTitle: String) {
        actionClickONDeleteButton(taskItemsView, textTitle)
    }

    fun actionEditTheTask(textTitle: String) {
        actionClickOnTheTask(taskItemsView, textTitle)
    }

    fun actionClickOnCompleteTheTask(textTitle: String) {
        actionClickOnCheckBox(taskItemsView, textTitle)
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
        assertTheTaskIsNotInTheList(taskItemsView, textTitle)
    }

    fun assertTaskAddedInTheList(textTitle: String, textDescription: String, date: String) {
        assertTheTaskIsInTheList(taskItemsView, textTitle, textDescription, date)
    }

    fun assertTheListIsEmpty(){
        taskItemsView{
            hasSize(0)
        }
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