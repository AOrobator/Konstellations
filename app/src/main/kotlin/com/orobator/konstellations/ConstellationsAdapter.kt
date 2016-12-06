package com.orobator.konstellations

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.orobator.konstellations.ConstellationsAdapter.ConstellationViewHolder

class ConstellationsAdapter()
  : RecyclerView.Adapter<ConstellationViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ConstellationViewHolder {
    val inflater = LayoutInflater.from((parent as View).context)
    val itemView = inflater.inflate(R.layout.list_item_constellation, parent, false)
    return ConstellationViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: ConstellationViewHolder, position: Int) {
    holder.bind(Constellation.values()[position])
  }

  override fun getItemCount(): Int = Constellation.values().size

  class ConstellationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @BindView(R.id.constellation_name) lateinit var constellationTextView: TextView

    init {
      ButterKnife.bind(this, itemView)
    }

    fun bind(constellation: Constellation) {
      constellationTextView.text = constellation.longName

      itemView.setOnClickListener {
        val intent = ConstellationDetailActivity.getIntent(it.context, constellation)
        it.context.startActivity(intent)
      }
    }
  }

}