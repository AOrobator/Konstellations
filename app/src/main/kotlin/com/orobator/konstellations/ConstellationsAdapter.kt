package com.orobator.konstellations

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.orobator.konstellations.ConstellationsAdapter.ConstellationViewHolder

class ConstellationsAdapter(val constellations: Array<String>)
  : RecyclerView.Adapter<ConstellationViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ConstellationViewHolder {
    val inflater = LayoutInflater.from((parent as View).context)
    val itemView = inflater.inflate(R.layout.list_item_constellation, parent, false)
    return ConstellationViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: ConstellationViewHolder?, position: Int) {
    holder?.bind(position)
  }

  override fun getItemCount(): Int = constellations.size

  inner class ConstellationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val constellationTextView = itemView.findViewById(R.id.constellation_name) as TextView

    fun bind(position: Int) {
      constellationTextView.text = constellations[position]
    }
  }

}