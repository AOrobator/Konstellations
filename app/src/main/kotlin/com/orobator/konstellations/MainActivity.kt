package com.orobator.konstellations

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife

class MainActivity : AppCompatActivity() {
  @BindView(R.id.constellations_recyclerview) lateinit var constellationsRecyclerView: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    ButterKnife.bind(this)

    constellationsRecyclerView.adapter = ConstellationsAdapter()
  }

  companion object {
    fun getIntent(context: Context): Intent {
      return Intent(context, MainActivity::class.java).apply {
        action = Intent.ACTION_VIEW
      }
    }
  }
}
