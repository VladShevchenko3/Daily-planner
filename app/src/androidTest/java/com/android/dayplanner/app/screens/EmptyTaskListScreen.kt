package com.android.dayplanner.app.screens

import com.android.dayplanner.app.R
import com.android.dayplanner.app.ui.home.HomeFragment
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView

object EmptyTaskListScreen : KScreen<EmptyTaskListScreen>() {

    override val layoutId = R.layout.tasks_list_placeholder
    override val viewClass = HomeFragment::class.java

    private val imageView = KImageView { withId(R.id.imageView) }
    private val textView = KTextView { withId(R.id.textView) }

    fun assertBackgroundImageIsVisible() {
        imageView.isVisible()
    }

    fun assertBackgroundTextIsVisible() {
        textView.hasText(R.string.no_tasks)
    }
}