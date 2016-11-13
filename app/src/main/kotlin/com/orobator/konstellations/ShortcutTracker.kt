package com.orobator.konstellations

import android.annotation.TargetApi
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutInfo.Builder
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.N_MR1
import android.preference.PreferenceManager
import com.orobator.konstellations.KonstellationsApplication.Companion.APP_CONTEXT
import kotlin.comparisons.compareBy

class ShortcutTracker {
  companion object {

    @TargetApi(N_MR1)
    fun trackShortcut(shortcutManager: ShortcutManager, constellation: Constellation) {
      shortcutManager.reportShortcutUsed(constellation.name)

      val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(APP_CONTEXT)
      val seenCount = sharedPrefs.getInt(constellation.name, 0)
      sharedPrefs.edit().putInt(constellation.name, seenCount + 1).apply()

      updateShortcuts(shortcutManager)
    }

    fun getShortcutVisitedCount(constellation: Constellation): Int {
      val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(APP_CONTEXT)
      return sharedPrefs.getInt(constellation.name, 0)
    }

    @TargetApi(N_MR1)
    fun updateShortcuts(shortcutManager: ShortcutManager) {
      val shortcutList: MutableList<ShortcutInfo> = mutableListOf()

      Constellation.values().sortedWith(
          compareBy { -getShortcutVisitedCount(it) }
      ).map {
        Builder(APP_CONTEXT, it.name)
            .setShortLabel(it.shortName)
            .setLongLabel(it.longName)
            .setIcon(Icon.createWithResource(APP_CONTEXT, R.drawable.shortcut_icon))
            .setIntents(
                arrayOf(
                    MainActivity.getIntent(APP_CONTEXT),
                    ConstellationDetailActivity.getIntent(APP_CONTEXT, it)
                )
            )
            .build()
      }
          .forEach { shortcutList += it }

      shortcutManager.dynamicShortcuts = shortcutList.subList(0, 4)
    }
  }
}

/**
 * Helper method to pass in usages of the shortcut api without having to do an
 * explicit version check every time
 */
inline fun shortcutAction(action: (ShortcutManager) -> Unit): Unit {
  if (SDK_INT >= N_MR1) {
    val shortcutManager = APP_CONTEXT.getSystemService(ShortcutManager::class.java)
    action(shortcutManager)
  }
}