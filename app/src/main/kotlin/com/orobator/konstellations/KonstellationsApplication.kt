package com.orobator.konstellations

import android.app.Application
import android.content.Context

class KonstellationsApplication : Application() {
  companion object {
    lateinit var APP_CONTEXT: Context
  }

  override fun onCreate() {
    super.onCreate()
    APP_CONTEXT = this
  }
}