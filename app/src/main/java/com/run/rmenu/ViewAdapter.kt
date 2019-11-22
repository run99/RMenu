package com.run.rmenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

class ViewAdapter(private val list: List<Data>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.foodTitle.text = list[position].food
        //   holder.detailView.text = list[position].detail

    }

    override fun getItemCount(): Int {
        return list.size
    }
}