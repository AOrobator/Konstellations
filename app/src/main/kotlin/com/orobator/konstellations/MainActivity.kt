package com.orobator.konstellations

import android.annotation.TargetApi
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.content.pm.ShortcutInfo.Builder
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.N_MR1
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import butterknife.BindArray
import butterknife.BindView
import butterknife.ButterKnife
import com.orobator.konstellations.R.mipmap
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
  @BindView(R.id.constellations_recyclerview) lateinit var constellationsRecyclerView: RecyclerView
  @BindArray(R.array.constellations) lateinit var constellations: Array<String>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    ButterKnife.bind(this)

    if (SDK_INT >= N_MR1) {
      addDynamicShortcuts()
    }

    constellationsRecyclerView.adapter = ConstellationsAdapter(constellations)
  }

  @TargetApi(N_MR1)
  private fun addDynamicShortcuts() {
    val currentDate = Date()

    val shortDateFormat = SimpleDateFormat("MMM d", Locale.US)
    val shortDate = shortDateFormat.format(currentDate)

    val longDateFormat = SimpleDateFormat("MMMM d, YYYY", Locale.US)
    val longDate = longDateFormat.format(currentDate)

    val shortcutInfo = Builder(this, "dynamic")
        .setShortLabel(shortDate)
        .setLongLabel(longDate)
        .setIcon(Icon.createWithResource(this, mipmap.ic_launcher))
        .setIntent(Intent(ACTION_VIEW, null, this, MainActivity::class.java))
        .build()

    val shortcutManager = getSystemService(ShortcutManager::class.java)
    shortcutManager.dynamicShortcuts = listOf(shortcutInfo)
  }
}
