package com.orobator.konstellations

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.os.Build.VERSION_CODES.N_MR1
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife

class ConstellationDetailActivity : AppCompatActivity() {
  @BindView(R.id.constellation_description) lateinit var description: TextView
  @BindView(R.id.toolbar) lateinit var toolbar: Toolbar
  @BindView(R.id.constellation_image) lateinit var constellationImage: ImageView

  lateinit var constellation: Constellation

  companion object {
    val KEY_CONSTELLATION = "key_constellation"

    fun getIntent(context: Context, constellation: Constellation): Intent {
      return Intent(context, ConstellationDetailActivity::class.java).apply {
        putExtra(KEY_CONSTELLATION, constellation.name)
        action = Intent.ACTION_VIEW
      }
    }
  }

  private fun Intent.getConstellation(): String = this.getStringExtra(KEY_CONSTELLATION)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_constellation_detail)
    ButterKnife.bind(this)

    setSupportActionBar(toolbar)
    supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    constellation = when (intent.action) {
      "RANDOM" -> Constellation.random()
      else -> Constellation.fromString(intent.getConstellation())
    }


    title = constellation.longName
    description.text = constellation.description
    constellationImage.setImageResource(constellation.image)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.detail_menu, menu)
    return true
  }

  @TargetApi(N_MR1)
  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      android.R.id.home -> finish()
    }
    return true
  }

}
