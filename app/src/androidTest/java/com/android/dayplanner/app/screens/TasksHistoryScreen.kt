package com.android.dayplanner.app.screens

import com.android.dayplanner.app.R
import com.android.dayplanner.app.screens.ListOfTasksBasic.TaskItem
import com.android.dayplanner.app.ui.tasks.TasksFragment
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView

object TasksHistoryScreen : KScreen<TasksHistoryScreen>(), ListOfTasksBasic {

    override val layoutId = R.layout.tasks_fragment
    override val viewClass = TasksFragment::class.java

    private val listOfCompetedTasks = KRecyclerView({
        withId(R.id.recyclerView)
    }, itemTypeBuilder = {
        itemType(::TaskItem)
    })

    fun actionUncheckTheTaskStatus(textTitle: String) {
        actionClickOnCheckBox(listOfCompetedTasks, textTitle)
    }

    fun actionPressBack() {
        pressBack()
    }

    fun actionDeleteTheTask(textTitle: String) {
        actionClickONDeleteButton(listOfCompetedTasks, textTitle)
    }

    fun actionEditTheTask(textTitle: String) {
        actionClickOnTheTask(listOfCompetedTasks, textTitle)
    }

    fun assertTheStatusOfTaskIsChecked(textTitle: String) {
        assertTheStatusIsChecked(listOfCompetedTasks, textTitle)
    }

    fun assertTaskAddedInTheTaskHistory(textTitle: String, textDescription: String, date: String) {
        assertTheTaskIsInTheList(listOfCompetedTasks, textTitle, textDescription, date)
    }

    fun assertRecyclerViewIsEmpty() {
        assertTheListIsEmpty(listOfCompetedTasks)
    }

    fun assertTaskIsNotPresentOnScreen(title: String) {
        assertTaskIsNotInList(listOfCompetedTasks, title)
    }
}