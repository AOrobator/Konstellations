package com.orobator.konstellations

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


enum class Constellation(val longName: String, desc: String, val shortName: String) {
  AQUARIUS(aquarius.getString(), aquarius_desc.getString(), aquarius.getString()),
  AQUILA(aquila.getString(), aquila_desc.getString(), aquila_short_name.getString()),
  ARIES(aries.getString(), aries_desc.getString(), aries_short_name.getString()),
  AURIGA(auriga.getString(), auriga_desc.getString(), auriga_short_name.getString()),
  BOOTES(bootes.getString(), bootes_desc.getString(), bootes_short_name.getString()),
  CANCER(cancer.getString(), cancer_desc.getString(), cancer_short_name.getString()),
  CANIS_MAJOR(canis_major.getString(), canis_major_desc.getString(), canis_major_short_name.getString()),
  CAPRICORNUS(capricornus.getString(), capricornus_desc.getString(), capricornus_short_name.getString()),
  CASSIOPEIA(cassiopeia.getString(), cassiopeia_desc.getString(), cassiopeia_short_name.getString()),
  CYGNUS(cygnus.getString(), cygnus_desc.getString(), cygnus_short_name.getString()),
  GEMINI(gemini.getString(), gemini_desc.getString(), gemini_short_name.getString()),
  LEO(leo.getString(), leo_desc.getString(), leo_short_name.getString()),
  LIBRA(libra.getString(), libra_desc.getString(), libra_short_name.getString()),
  LYRA(lyra.getString(), lyra_desc.getString(), lyra_short_name.getString()),
  ORION(orion.getString(), orion_desc.getString(), orion_short_name.getString()),
  PEGASUS(pegasus.getString(), pegasus_desc.getString(), pegasus_short_name.getString()),
  PERSEUS(perseus.getString(), perseus_desc.getString(), perseus_short_name.getString()),
  PISCES(pisces.getString(), pisces_desc.getString(), pisces_short_name.getString()),
  SAGITTARIUS(sagittarius.getString(), sagittarius_desc.getString(), sagittarius_short_name.getString()),
  SCORPIUS(scorpius.getString(), scorpius_desc.getString(), scorpius_short_name.getString()),
  TAURUS(taurus.getString(), taurus_desc.getString(), taurus_short_name.getString()),
  URSA_MAJOR(ursa_major.getString(), ursa_major_desc.getString(), ursa_major_short_name.getString()),
  VIRGO(virgo.getString(), virgo_desc.getString(), virgo.getString());

  val description = desc + R.string.content_attribution.getString()

  companion object {
    fun fromString(name: String) : Constellation {
      return Constellation.values().filter { it.name == name }.first()
    }

    fun random() : Constellation = values()[Random().nextInt(values().size)]

  }
}