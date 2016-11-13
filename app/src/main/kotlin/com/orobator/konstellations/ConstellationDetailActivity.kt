package com.orobator.konstellations

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.orobator.konstellations.R.id.disable_shortcut
import com.orobator.konstellations.R.id.enable_shortcut
import com.orobator.konstellations.R.string.shortcut_disabled
import com.orobator.konstellations.R.string.shortcut_enabled

class ConstellationDetailActivity : AppCompatActivity() {
  @BindView(R.id.constellation_description) lateinit var description: TextView
  lateinit var constellation: Constellation

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

    constellation = if (intent.action == "RANDOM") {
      Constellation.random()
    } else {
      val constellationName = intent.getStringExtra(KEY_CONSTELLATION)
      Constellation.fromString(constellationName)
    }

    shortcutAction {
      ShortcutTracker.trackShortcut(it, constellation)
    }

    title = constellation.longName
    description.text = constellation.description
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.detail_menu, menu)
    return true
  }

  @TargetApi(Build.VERSION_CODES.N_MR1)
  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      enable_shortcut -> shortcutAction {
        it.enableShortcuts(listOf(constellation.name))
        alertUser(shortcut_enabled)
      }

      disable_shortcut -> shortcutAction {
        it.disableShortcuts(listOf(constellation.name))
        alertUser(shortcut_disabled)
      }
    }
    return true
  }

}
