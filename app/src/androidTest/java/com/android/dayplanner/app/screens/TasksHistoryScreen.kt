package com.android.dayplanner.app.screens

import com.android.dayplanner.app.R
import com.android.dayplanner.app.screens.ListOfTasksBasic.TaskItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen

class TasksHistoryScreen : Screen<TasksHistoryScreen>(), ListOfTasksBasic {

    private val taskItemsView = KRecyclerView({
        withId(R.id.recyclerView)
    }, itemTypeBuilder = {
        itemType(::TaskItem)
    })

    fun actionClickOnCompleteTaskButton(textTitle: String) {
        actionClickOnCheckBox(taskItemsView, textTitle)
    }

    fun actionPressBack() {
        pressBack()
    }
}