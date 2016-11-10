package com.orobator.konstellations

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.orobator.konstellations.ConstellationsAdapter.ConstellationViewHolder

class ConstellationsAdapter : RecyclerView.Adapter<ConstellationViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ConstellationViewHolder {
    val inflater = LayoutInflater.from((parent as View).context)
    val itemView = inflater.inflate(R.layout.list_item_constellation, parent, false)
    return ConstellationViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: ConstellationViewHolder?, position: Int) {
  }

  override fun getItemCount(): Int = 20

  class ConstellationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}