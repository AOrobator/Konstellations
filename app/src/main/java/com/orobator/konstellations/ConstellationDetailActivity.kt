package com.orobator.konstellations

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutManager
import android.os.Build.VERSION_CODES.N_MR1
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.orobator.konstellations.AndroidExtensions.Companion.hasAppShortcuts

class ConstellationDetailActivity : AppCompatActivity() {
  @BindView(R.id.constellation_description) lateinit var description: TextView

  companion object {
    val KEY_CONSTELLATION = "key_constellation"

    fun getIntent(context: Context, constellation: Constellation): Intent {
      val intent = Intent(context, ConstellationDetailActivity::class.java)
      intent.putExtra(KEY_CONSTELLATION, constellation.name)
      intent.action = Intent.ACTION_VIEW
      return intent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_constellation_detail)
    ButterKnife.bind(this)

    val constellation: Constellation = Constellation.fromString(
        intent.getStringExtra(KEY_CONSTELLATION))

    if (hasAppShortcuts()) {
      trackShortcutUsed(constellation)
    }

    title = constellation.constellationName
    description.text = constellation.description

  }

  @TargetApi(N_MR1)
  private fun trackShortcutUsed(constellation: Constellation) {
    val shortcutManager = getSystemService(ShortcutManager::class.java)
    shortcutManager.reportShortcutUsed(constellation.name)
  }
}
