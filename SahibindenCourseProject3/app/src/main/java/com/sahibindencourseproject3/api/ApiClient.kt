package com.sahibindencourseproject3.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Ataer Caner on 2020-01-30.
 *
 */

object ApiClient {

    private var retrofit: Retrofit? = null

    val client: Retrofit
        get() {
            retrofit = Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/data/2.5/forecast/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit!!
        }
}