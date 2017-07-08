package com.orobator.konstellations

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ShortcutPinnedReceiver : BroadcastReceiver() {

  override fun onReceive(context: Context, intent: Intent) {
    Toast.makeText(context, "Shortcut Pinned!", Toast.LENGTH_SHORT).show()
  }
}
