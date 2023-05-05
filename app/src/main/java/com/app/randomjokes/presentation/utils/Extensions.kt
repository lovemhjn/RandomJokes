package com.app.randomjokes.presentation.utils

import androidx.core.widget.ContentLoadingProgressBar

fun ContentLoadingProgressBar.makeVisible(isVisible: Boolean) {
	if(isVisible) show() else hide()
}