package com.android.dayplanner.app.screens

import com.android.dayplanner.app.R
import com.android.dayplanner.app.screens.ListOfTasksBasic.ListOfTasks
import com.android.dayplanner.app.ui.tasks.TasksFragment
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView

object TasksHistoryScreen : KScreen<TasksHistoryScreen>(), ListOfTasksBasic {

    override val layoutId = R.layout.item_task
    override val viewClass = TasksFragment::class.java

    private val listOfCompetedTasks = KRecyclerView({
        withId(R.id.recyclerView)
    }, itemTypeBuilder = {
        itemType(::ListOfTasks)
    })

    fun actionClickOnCompleteTaskButton(textTitle: String) {
        actionClickOnCheckBox(listOfCompetedTasks, textTitle)
    }

    fun actionPressBack() {
        pressBack()
    }
}