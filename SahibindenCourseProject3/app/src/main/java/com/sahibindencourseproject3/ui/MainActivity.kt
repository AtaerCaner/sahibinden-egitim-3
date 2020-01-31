package com.sahibindencourseproject3.ui

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sahibindencourseproject3.R
import com.sahibindencourseproject3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainActiviyViewModel by lazy { ViewModelProvider(this).get(MainActivityViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = DataBindingUtil.
                setContentView(this,
                        R.layout.activity_main)


        mainActiviyViewModel.getLiveWeatherItems().observe(this, Observer {
            binding.day = "Cuma"
            binding.weatherItem = it?.weatherItem?.get(0)
        })

        mainActiviyViewModel.fetchDatas()
    }



}
