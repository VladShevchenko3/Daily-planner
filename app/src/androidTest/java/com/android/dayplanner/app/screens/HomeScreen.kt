package com.android.dayplanner.app.screens

import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import com.android.dayplanner.app.R
import com.android.dayplanner.app.screens.ListOfTasksBasic.ListOfTasks
import com.android.dayplanner.app.ui.MainActivity
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import junit.framework.AssertionFailedError

object HomeScreen : KScreen<HomeScreen>(), ListOfTasksBasic {

    override val layoutId = R.layout.home_fragment
    override val viewClass = MainActivity::class.java

    private val fabTaskButton = KButton { withId(R.id.floating_action_button) }
    private val showTaskHistoryView = KView { withText(R.string.label_history) }
    private val listOfTasksView = KRecyclerView({
        withId(R.id.recyclerView)
    }, itemTypeBuilder = {
        itemType(::ListOfTasks)
    })
    private val deleteAllTaskView = KView { withText(R.string.label_delete_all) }
    private val yesView = KView { withText(R.string.yes) }

    fun actionClickOnFabTaskButton() {
        fabTaskButton.click()
    }

    fun actionDeleteTheTask(textTitle: String) {
        actionClickONDeleteButton(listOfTasksView, textTitle)
    }

    fun actionEditTheTask(textTitle: String) {
        actionClickOnTheTask(listOfTasksView, textTitle)
    }

    fun actionClickOnCompleteTheTask(textTitle: String) {
        actionClickOnCheckBox(listOfTasksView, textTitle)
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
        assertTheTaskIsNotInTheList(listOfTasksView, textTitle)
    }

    fun assertTaskAddedInTheList(textTitle: String, textDescription: String, date: String) {
        assertTheTaskIsInTheList(listOfTasksView, textTitle, textDescription, date)
    }
}