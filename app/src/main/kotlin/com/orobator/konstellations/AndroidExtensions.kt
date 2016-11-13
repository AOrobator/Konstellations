package com.orobator.konstellations

import com.orobator.konstellations.KonstellationsApplication.Companion.APP_CONTEXT

fun Int.getString(): String = APP_CONTEXT.getString(this)
