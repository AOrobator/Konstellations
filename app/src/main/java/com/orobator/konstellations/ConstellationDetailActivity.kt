package com.orobator.konstellations

import android.content.Context
import android.content.Intent
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

    val constellation: Constellation = if (intent.action == "RANDOM") {
      Constellation.random()
    } else {
      val constellationName = intent.getStringExtra(KEY_CONSTELLATION)
      Constellation.fromString(constellationName)
    }

    if (hasAppShortcuts()) {
      ShortcutTracker.trackShortcut(this, constellation)
    }

    title = constellation.longName
    description.text = constellation.description

  }

}
