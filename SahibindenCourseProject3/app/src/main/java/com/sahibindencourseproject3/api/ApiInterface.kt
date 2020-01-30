package com.sahibindencourseproject3.api

import com.sahibindencourseproject3.api.model.DailyForecastResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Ataer Caner on 2020-01-30.
 *
 */

interface ApiInterface {

    @GET("daily")
    fun getDailyforecast(@Query("q") cityname: String,
                         @Query("units") units: String,
                         @Query("cnt") count: Int,
                         @Query("appid") appid: String): Call<DailyForecastResponse>

}