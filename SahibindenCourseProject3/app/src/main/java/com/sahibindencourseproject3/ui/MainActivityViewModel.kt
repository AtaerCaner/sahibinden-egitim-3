package com.sahibindencourseproject3.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sahibindencourseproject3.api.model.DailyForecastResponse
import com.sahibindencourseproject3.manager.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by Ataer Caner on 2020-01-31.
Copyright (c) 2020 sahibinden. All rights reserved.
 *
 */

class MainActivityViewModel(app: Application): AndroidViewModel(app) {
    private val weatherItems =  MutableLiveData<DailyForecastResponse>()


    fun fetchDatas() {
        NetworkManager.getDailyForecast("istanbul").enqueue(object : Callback<DailyForecastResponse> {
            override fun onFailure(call: Call<DailyForecastResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<DailyForecastResponse>, response: Response<DailyForecastResponse>) {
                weatherItems.value = response.body()
            }

        })
    }


    fun getLiveWeatherItems(): LiveData<DailyForecastResponse> = weatherItems
}