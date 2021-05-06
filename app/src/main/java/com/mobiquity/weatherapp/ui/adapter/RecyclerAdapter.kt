package com.mobiquity.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobiquity.weatherapp.R
import com.mobiquity.weatherapp.ui.interfaces.RecycleOnClickInterface

class RecyclerAdapter(
    private val locationCity: MutableList<String>,
    var listener: RecycleOnClickInterface
) : RecyclerView.Adapter<RecyclerAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.location_item, parent, false)
        return ItemHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val cityName = locationCity[position]
        holder.cityName.text = cityName
        holder.cityFirstLetter.text = cityName.substring(0,1)

        holder.itemView.setOnClickListener({
           listener.itemCLickPerform(cityName)
        })
    }

    override fun getItemCount() : Int = locationCity.size

    fun addItem(name: String) {
        locationCity.add(name)
        notifyItemInserted(locationCity.size)
    }

    fun removeAt(position: Int) {
        locationCity.removeAt(position)
        notifyItemRemoved(position)
    }

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cityFirstLetter: TextView = view.findViewById(R.id.tv_first_letter_city_name)
        var cityName: TextView = view.findViewById(R.id.tv_city_name)
    }
}

