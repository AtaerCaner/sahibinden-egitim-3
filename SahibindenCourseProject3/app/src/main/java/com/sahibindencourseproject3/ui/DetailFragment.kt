package com.sahibindencourseproject3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sahibindencourseproject3.R
import com.sahibindencourseproject3.api.model.WeatherItem


/**
 * Created by Ataer Caner on 2020-01-31.
Copyright (c) 2020 sahibinden. All rights reserved.
 *
 */

class DetailFragment: Fragment() {
    val weatherItem by lazy { arguments?.getParcelable<WeatherItem>(DetailActivity.BUNDLE_WEATHER_ITEM) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_detail, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        print(weatherItem)
    }



}