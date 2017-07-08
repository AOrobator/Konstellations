package com.orobator.konstellations

import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutInfo.Builder
import android.graphics.drawable.Icon
import com.orobator.konstellations.KonstellationsApplication.Companion.APP_CONTEXT
import com.orobator.konstellations.R.drawable
import com.orobator.konstellations.R.drawable.aquarius_img
import com.orobator.konstellations.R.drawable.aquila_img
import com.orobator.konstellations.R.drawable.aries_img
import com.orobator.konstellations.R.drawable.auriga_img
import com.orobator.konstellations.R.drawable.bootes_img
import com.orobator.konstellations.R.drawable.cancer_img
import com.orobator.konstellations.R.drawable.canis_major_img
import com.orobator.konstellations.R.drawable.capricornus_img
import com.orobator.konstellations.R.drawable.cassiopeia_img
import com.orobator.konstellations.R.drawable.cygnus_lyra_img
import com.orobator.konstellations.R.drawable.gemini_img
import com.orobator.konstellations.R.drawable.leo_img
import com.orobator.konstellations.R.drawable.libra_img
import com.orobator.konstellations.R.drawable.orion_img
import com.orobator.konstellations.R.drawable.pegasus_img
import com.orobator.konstellations.R.drawable.perseus_img
import com.orobator.konstellations.R.drawable.pisces_img
import com.orobator.konstellations.R.drawable.sagittarius_img
import com.orobator.konstellations.R.drawable.scorpius_img
import com.orobator.konstellations.R.drawable.taurus_img
import com.orobator.konstellations.R.drawable.ursa_major_img
import com.orobator.konstellations.R.drawable.virgo_img
import com.orobator.konstellations.R.string.aquarius
import com.orobator.konstellations.R.string.aquarius_desc
import com.orobator.konstellations.R.string.aquila
import com.orobator.konstellations.R.string.aquila_desc
import com.orobator.konstellations.R.string.aquila_short_name
import com.orobator.konstellations.R.string.aries
import com.orobator.konstellations.R.string.aries_desc
import com.orobator.konstellations.R.string.aries_short_name
import com.orobator.konstellations.R.string.auriga
import com.orobator.konstellations.R.string.auriga_desc
import com.orobator.konstellations.R.string.auriga_short_name
import com.orobator.konstellations.R.string.bootes
import com.orobator.konstellations.R.string.bootes_desc
import com.orobator.konstellations.R.string.bootes_short_name
import com.orobator.konstellations.R.string.cancer
import com.orobator.konstellations.R.string.cancer_desc
import com.orobator.konstellations.R.string.cancer_short_name
import com.orobator.konstellations.R.string.canis_major
import com.orobator.konstellations.R.string.canis_major_desc
import com.orobator.konstellations.R.string.canis_major_short_name
import com.orobator.konstellations.R.string.capricornus
import com.orobator.konstellations.R.string.capricornus_desc
import com.orobator.konstellations.R.string.capricornus_short_name
import com.orobator.konstellations.R.string.cassiopeia
import com.orobator.konstellations.R.string.cassiopeia_desc
import com.orobator.konstellations.R.string.cassiopeia_short_name
import com.orobator.konstellations.R.string.content_attribution
import com.orobator.konstellations.R.string.cygnus
import com.orobator.konstellations.R.string.cygnus_desc
import com.orobator.konstellations.R.string.cygnus_short_name
import com.orobator.konstellations.R.string.gemini
import com.orobator.konstellations.R.string.gemini_desc
import com.orobator.konstellations.R.string.gemini_short_name
import com.orobator.konstellations.R.string.leo
import com.orobator.konstellations.R.string.leo_desc
import com.orobator.konstellations.R.string.leo_short_name
import com.orobator.konstellations.R.string.libra
import com.orobator.konstellations.R.string.libra_desc
import com.orobator.konstellations.R.string.libra_short_name
import com.orobator.konstellations.R.string.lyra
import com.orobator.konstellations.R.string.lyra_desc
import com.orobator.konstellations.R.string.lyra_short_name
import com.orobator.konstellations.R.string.orion
import com.orobator.konstellations.R.string.orion_desc
import com.orobator.konstellations.R.string.orion_short_name
import com.orobator.konstellations.R.string.pegasus
import com.orobator.konstellations.R.string.pegasus_desc
import com.orobator.konstellations.R.string.pegasus_short_name
import com.orobator.konstellations.R.string.perseus
import com.orobator.konstellations.R.string.perseus_desc
import com.orobator.konstellations.R.string.perseus_short_name
import com.orobator.konstellations.R.string.pisces
import com.orobator.konstellations.R.string.pisces_desc
import com.orobator.konstellations.R.string.pisces_short_name
import com.orobator.konstellations.R.string.sagittarius
import com.orobator.konstellations.R.string.sagittarius_desc
import com.orobator.konstellations.R.string.sagittarius_short_name
import com.orobator.konstellations.R.string.scorpius
import com.orobator.konstellations.R.string.scorpius_desc
import com.orobator.konstellations.R.string.scorpius_short_name
import com.orobator.konstellations.R.string.taurus
import com.orobator.konstellations.R.string.taurus_desc
import com.orobator.konstellations.R.string.taurus_short_name
import com.orobator.konstellations.R.string.ursa_major
import com.orobator.konstellations.R.string.ursa_major_desc
import com.orobator.konstellations.R.string.ursa_major_short_name
import com.orobator.konstellations.R.string.virgo
import com.orobator.konstellations.R.string.virgo_desc
import java.util.Random

enum class Constellation(longNameRes: Int, desc: Int, shortNameRes: Int, val image: Int) {
  AQUARIUS(aquarius, aquarius_desc, aquarius, aquarius_img),
  AQUILA(aquila, aquila_desc, aquila_short_name, aquila_img),
  ARIES(aries, aries_desc, aries_short_name, aries_img),
  AURIGA(auriga, auriga_desc, auriga_short_name, auriga_img),
  BOOTES(bootes, bootes_desc, bootes_short_name, bootes_img),
  CANCER(cancer, cancer_desc, cancer_short_name, cancer_img),
  CANIS_MAJOR(canis_major, canis_major_desc, canis_major_short_name, canis_major_img),
  CAPRICORNUS(capricornus, capricornus_desc, capricornus_short_name, capricornus_img),
  CASSIOPEIA(cassiopeia, cassiopeia_desc, cassiopeia_short_name, cassiopeia_img),
  CYGNUS(cygnus, cygnus_desc, cygnus_short_name, cygnus_lyra_img),
  GEMINI(gemini, gemini_desc, gemini_short_name, gemini_img),
  LEO(leo, leo_desc, leo_short_name, leo_img),
  LIBRA(libra, libra_desc, libra_short_name, libra_img),
  LYRA(lyra, lyra_desc, lyra_short_name, cygnus_lyra_img),
  ORION(orion, orion_desc, orion_short_name, orion_img),
  PEGASUS(pegasus, pegasus_desc, pegasus_short_name, pegasus_img),
  PERSEUS(perseus, perseus_desc, perseus_short_name, perseus_img),
  PISCES(pisces, pisces_desc, pisces_short_name, pisces_img),
  SAGITTARIUS(sagittarius, sagittarius_desc, sagittarius_short_name, sagittarius_img),
  SCORPIUS(scorpius, scorpius_desc, scorpius_short_name, scorpius_img),
  TAURUS(taurus, taurus_desc, taurus_short_name, taurus_img),
  URSA_MAJOR(ursa_major, ursa_major_desc, ursa_major_short_name, ursa_major_img),
  VIRGO(virgo, virgo_desc, virgo, virgo_img);

  val description = desc.getString() + content_attribution.getString()
  val longName = longNameRes.getString()
  val shortName = shortNameRes.getString()

  companion object {
    fun fromString(name: String) : Constellation {
      return Constellation.values().filter { it.name == name }.first()
    }

    fun random() : Constellation = values()[Random().nextInt(values().size)]

  }

  fun toShortcutInfo(): ShortcutInfo {
    return Builder(APP_CONTEXT, name)
        .setShortLabel(shortName)
        .setLongLabel(longName)
        .setIcon(
            Icon.createWithResource(APP_CONTEXT, drawable.shortcut_icon))
        .setIntents(
            arrayOf(
                // This intent is used for the back-stack
                MainActivity.getIntent(APP_CONTEXT),
                // This intent is what gets initially launched
                ConstellationDetailActivity.getIntent(APP_CONTEXT, this)
            )
        )
        .build()

  }
}