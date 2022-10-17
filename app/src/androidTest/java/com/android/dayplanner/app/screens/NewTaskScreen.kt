package com.android.dayplanner.app.screens

import com.android.dayplanner.app.R
import com.android.dayplanner.app.ui.detail.TaskDetailsFragment
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton

object NewTaskScreen : KScreen<NewTaskScreen>() {

    override val layoutId = R.layout.task_details_fragment
    override val viewClass = TaskDetailsFragment::class.java

    private val buttonSaveTask = KButton { withId(R.id.button_saveTask) }
    private val editTextTitle = KEditText { withId(R.id.editText_title) }
    private val editTextDescription = KEditText { withId(R.id.editText_description) }
    private val editTextDate = KEditText { withId(R.id.editText_taskDate) }

    fun actionEditTextTitle(textTitle: String) {
        editTextTitle {
            clearText()
            typeText(textTitle)
        }
        closeSoftKeyboard()
    }

    fun actionEditTextDescription(textDescription: String) {
        editTextDescription.typeText(textDescription)
        closeSoftKeyboard()
    }

    fun actionEditTextData(textData: String) {
        editTextDate.typeText(textData)
        closeSoftKeyboard()
    }

    fun actionClickOnSaveButton() {
        buttonSaveTask.click()
    }
}