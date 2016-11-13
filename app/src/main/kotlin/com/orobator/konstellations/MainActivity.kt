package com.orobator.konstellations

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutInfo.Builder
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build.VERSION_CODES.N_MR1
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.orobator.konstellations.AndroidExtensions.Companion.hasAppShortcuts
import com.orobator.konstellations.R.mipmap
import kotlin.comparisons.compareBy

class MainActivity : AppCompatActivity() {
  @BindView(R.id.constellations_recyclerview) lateinit var constellationsRecyclerView: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    ButterKnife.bind(this)

    if (hasAppShortcuts()) {
      addDynamicShortcuts()
    }

    constellationsRecyclerView.adapter = ConstellationsAdapter()
  }

  @TargetApi(N_MR1)
  private fun addDynamicShortcuts() {
    val shortcutList: MutableList<ShortcutInfo> = mutableListOf()

    Constellation.values().sortedWith(
        compareBy { -ShortcutTracker.getShortcutVisitedCount(this, it) }
    ).map {
      Builder(this, it.name)
          .setShortLabel(it.shortName)
          .setLongLabel(it.longName)
          .setIcon(Icon.createWithResource(this, mipmap.ic_launcher))
          .setIntents(arrayOf(getIntent(this), ConstellationDetailActivity.getIntent(this, it)))
          .build()
    }
        .forEach { shortcutList += it }

    val shortcutManager = getSystemService(ShortcutManager::class.java)
    shortcutManager.dynamicShortcuts = shortcutList.subList(0, 4)
  }

  fun getIntent(context: Context): Intent {
    val intent = Intent(context, MainActivity::class.java)
    intent.action = Intent.ACTION_VIEW
    return intent
  }
}
