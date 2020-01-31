package com.sahibindencourseproject3.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahibindencourseproject3.R
import com.sahibindencourseproject3.adapter.WeatherItemAdapter
import com.sahibindencourseproject3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainActiviyViewModel by lazy { ViewModelProvider(this).get(MainActivityViewModel::class.java) }

    private var adapter: WeatherItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.
                setContentView(this,
                        R.layout.activity_main)

        adapter = WeatherItemAdapter({
            Toast.makeText(this,"" + it.temp?.day , Toast.LENGTH_SHORT).show()
        })

        binding.rc.layoutManager = LinearLayoutManager(this)
        binding.rc.adapter = adapter

        mainActiviyViewModel.getLiveWeatherItems().observe(this, Observer {
            binding.day = "Cuma"
            binding.weatherItem = it?.weatherItem?.get(0)

            adapter?.setItemList(it?.weatherItem!!)
        })

        mainActiviyViewModel.fetchDatas()
    }



}
