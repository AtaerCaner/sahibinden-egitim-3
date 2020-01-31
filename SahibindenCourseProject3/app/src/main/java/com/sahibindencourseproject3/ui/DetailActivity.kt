package com.sahibindencourseproject3.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.sahibindencourseproject3.R
import com.sahibindencourseproject3.api.model.WeatherItem
import com.sahibindencourseproject3.ext.addToCommit


/**
 * Created by Ataer Caner on 2020-01-31.
Copyright (c) 2020 sahibinden. All rights reserved.
 *
 */

class DetailActivity : AppCompatActivity() {

    val weatherItem: WeatherItem by lazy { intent!!.getParcelableExtra<WeatherItem>(BUNDLE_WEATHER_ITEM) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailFragment = DetailFragment()
        val bundle = Bundle()

        bundle.putParcelable(BUNDLE_WEATHER_ITEM, weatherItem)
        detailFragment.arguments = bundle


        supportFragmentManager.addToCommit(R.id.frmDetail, detailFragment)

    }


    companion object{
        val BUNDLE_WEATHER_ITEM = "BUNDLE_WEATHER_ITEM"
    }
}