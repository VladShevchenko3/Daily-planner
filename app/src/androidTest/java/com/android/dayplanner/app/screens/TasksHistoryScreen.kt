package com.android.dayplanner.app.screens

import com.android.dayplanner.app.R
import com.android.dayplanner.app.screens.ListOfTasksBasic.RecyclerOfTasks
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen

class TasksHistoryScreen : Screen<TasksHistoryScreen>(), ListOfTasksBasic {

    private val recyclerViewOfCompetedTasks = KRecyclerView({
        withId(R.id.recyclerView)
    }, itemTypeBuilder = {
        itemType(::RecyclerOfTasks)
    })

    fun actionClickOnCompleteTaskButton(textTitle: String) {
        actionClickOnCheckBox(recyclerViewOfCompetedTasks, textTitle)
    }

    fun actionPressBack() {
        pressBack()
    }
}