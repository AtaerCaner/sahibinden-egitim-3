package com.sahibindencourseproject3.manager

import com.sahibindencourseproject3.api.ApiClient
import com.sahibindencourseproject3.api.ApiInterface
import com.sahibindencourseproject3.api.model.DailyForecastResponse
import retrofit2.Call


/**
 * Created by Ataer Caner on 2020-01-30.
 *
 */

object NetworkManager {

    private var apiInterface: ApiInterface? = null

    private val API_KEY = "33e39f544e0da25b3687090c132dc0a9"
    private val CELCIUS = "metric"

    private val apiInterfaceInstance: ApiInterface
        get() {
            if (apiInterface==null) {
                apiInterface = ApiClient.client.create(ApiInterface::class.java)
            }

            return apiInterface!!
        }

    fun getDailyForecast(cityName: String): Call<DailyForecastResponse> {
        return apiInterfaceInstance.getDailyforecast(cityName,
                CELCIUS,
                10, API_KEY)
    }
}