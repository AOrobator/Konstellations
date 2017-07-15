package com.orobator.konstellations

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ShortcutPinnedReceiver : BroadcastReceiver() {

  override fun onReceive(context: Context, intent: Intent) {
    val shortcutName = intent.getStringExtra(Intent.EXTRA_TITLE)
    Toast.makeText(context, "$shortcutName Pinned!", Toast.LENGTH_SHORT).show()
  }
}
