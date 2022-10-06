package com.android.dayplanner.app.screens

import android.view.View
import com.android.dayplanner.app.R
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

class ListOfTaskFragment(parent: Matcher<View>) : KRecyclerItem<ListOfTaskFragment>(parent) {
    val titleTextField = KTextView(parent) { withId(R.id.textView_title) }
    val descriptionTextField = KTextView(parent) { withId(R.id.textView_description) }
    val dateTextField = KTextView(parent) { withId(R.id.textView_date) }
    val deleteTaskButton = KImageView(parent) { withId(R.id.imageView_delete) }
    val completeTaskCheckBox = KCheckBox(parent) { withId(R.id.checkBox) }
}