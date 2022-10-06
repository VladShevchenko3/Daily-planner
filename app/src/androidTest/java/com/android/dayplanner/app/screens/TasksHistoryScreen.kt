package com.android.dayplanner.app.screens

import com.android.dayplanner.app.R
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen

class TasksHistoryScreen : Screen<TasksHistoryScreen>() {

    private val recyclerView = KRecyclerView({
        withId(R.id.recyclerView)
    }, itemTypeBuilder = {
        itemType(::ListOfTaskFragment)
    })

    fun actionClickOnCompleteTaskButton(textTitle: String) {
        recyclerView {
            childWith<ListOfTaskFragment> {
                withDescendant { withText(textTitle) }
            } perform {
                completeTaskCheckBox.click()
            }
        }
    }

    fun actionPressBack() {
        pressBack()
    }
}