package com.orobator.konstellations

import android.annotation.TargetApi
import android.app.Application
import android.content.Context
import android.os.Build.VERSION_CODES.N_MR1

class KonstellationsApplication : Application() {
  companion object {
    lateinit var APP_CONTEXT: Context
  }

  @TargetApi(N_MR1)
  override fun onCreate() {
    super.onCreate()
    APP_CONTEXT = this

    shortcutAction(::updateShortcuts)
  }
}