package com.orobator.konstellations

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.N_MR1

fun Int.getString() : String = KonstellationsApplication.APP_CONTEXT.getString(this)

class AndroidExtensions {
  companion object {

    @JvmStatic
    fun hasAppShortcuts() : Boolean = SDK_INT >= N_MR1
  }
}