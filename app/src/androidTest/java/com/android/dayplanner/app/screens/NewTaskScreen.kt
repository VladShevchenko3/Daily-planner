package com.android.dayplanner.app.screens

import com.android.dayplanner.app.R
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton

class NewTaskScreen : Screen<NewTaskScreen>() {

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