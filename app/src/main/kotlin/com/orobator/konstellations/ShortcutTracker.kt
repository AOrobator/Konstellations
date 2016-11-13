package com.orobator.konstellations

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.ShortcutManager
import android.os.Build.VERSION_CODES.N_MR1
import android.preference.PreferenceManager

class ShortcutTracker {
  companion object {

    @TargetApi(N_MR1)
    fun trackShortcut(context: Context, constellation: Constellation) {
      val shortcutManager = context.getSystemService(ShortcutManager::class.java)
      shortcutManager.reportShortcutUsed(constellation.name)

      val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
      val seenCount = sharedPrefs.getInt(constellation.name, 0)
      sharedPrefs.edit().putInt(constellation.name, seenCount + 1).apply()
    }

    fun getShortcutVisitedCount(context: Context, constellation: Constellation) : Int {
      val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
      return sharedPrefs.getInt(constellation.name, 0)
    }
  }
}