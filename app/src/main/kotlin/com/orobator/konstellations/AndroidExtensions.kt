package com.orobator.konstellations

import android.app.Activity
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.design.widget.Snackbar.LENGTH_SHORT
import android.view.View
import com.orobator.konstellations.KonstellationsApplication.Companion.APP_CONTEXT

fun Int.getString(): String = APP_CONTEXT.getString(this)

fun Activity.getView(): View = findViewById(android.R.id.content)

fun Activity.alertUser(@StringRes message: Int) {
  Snackbar.make(getView(), message.getString(), LENGTH_SHORT).show()
}