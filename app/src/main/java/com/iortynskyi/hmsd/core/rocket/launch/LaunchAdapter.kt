package com.iortynskyi.hmsd.core.rocket.launch

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iortynskyi.hmsd.R
import com.iortynskyi.hmsd.core.rocket.launch.domain.data.Launch
import com.iortynskyi.hmsd.core.rocket.launch.domain.data.LaunchStatus
import com.iortynskyi.hmsd.extensions.setTextColorRes
import kotlinx.android.synthetic.main.item_launch.view.*

class LaunchAdapter(private val launches: MutableList<Launch> = mutableListOf(),
                    private val listener: LaunchCallbacks) : RecyclerView.Adapter<LaunchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_launch, parent, false), listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(launches[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return launches.size
    }

    fun getItem(position: Int): Launch = launches[position]

    fun addItems(items: List<Launch>) {
        launches.clear()
        launches.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View, listener: LaunchCallbacks) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener { listener.onItemClick(adapterPosition) }
            itemView.favorite.setOnClickListener { listener.onFavoriteClick(adapterPosition) }
        }

        fun bindItem(launch: Launch) {
            val status = LaunchStatus.fromInteger(launch.status)
            itemView.launchName.text = launch.name
            itemView.launchWindowStart.text = launch.windowStart
            itemView.launchWindowEnd.text = launch.windowEnd
            itemView.launchStatus.text = status.name
            itemView.launchStatus.setTextColorRes(status.color)
            itemView.favorite.setImageResource(if (launch.favorite) R.drawable.ic_favorite else R.drawable.ic_favorite_border)
        }
    }
}