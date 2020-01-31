package com.sahibindencourseproject3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sahibindencourseproject3.R
import com.sahibindencourseproject3.api.model.WeatherItem
import com.sahibindencourseproject3.util.DateUtil
import com.sahibindencourseproject3.util.TemperatureUtil


/**
 * Created by Ataer Caner on 2020-01-31.
 *
 */

class WeatherItemAdapter(private val itemClickListener: (WeatherItem) -> Unit) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var weatherItems: ArrayList<WeatherItem>? = null

    init {
        weatherItems = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val view = LayoutInflater.
                from(parent.context).
                inflate(R.layout.view_adapter_item,parent,false)

        return WeatherViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var weatherItem  = weatherItems?.get(position)
        var itemHolder = holder as WeatherViewHolder
        itemHolder.bind(position,weatherItem!!, itemClickListener)
    }

    override fun getItemCount(): Int {
        return weatherItems!!.size
    }

    fun setItemList(weatherItemList: ArrayList<WeatherItem>) {
        this.weatherItems = weatherItemList
        notifyDataSetChanged()
    }

    class WeatherViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        var txtDay: TextView? = null
        var txtTemp: TextView? = null

        init {
            txtDay = view.findViewById(R.id.txtDay)
            txtTemp = view.findViewById(R.id.txtTemp)
        }

        fun bind(position:Int,
                 weatherItem: WeatherItem,
                 itemListener: (WeatherItem)->Unit) {
            txtDay?.text = DateUtil.getGivenDayOfWeekAsName(
                    (position + DateUtil.todaysDayOfWeekAsIndex) % 7
            )
            txtTemp?.text = TemperatureUtil.getCelcius(weatherItem.temp?.day)
            view.setOnClickListener { itemListener.invoke(weatherItem) }
        }
    }
}