package com.sahibindencourseproject3

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import com.sahibindencourseproject3.api.model.DailyForecastResponse
import com.sahibindencourseproject3.manager.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NetworkManager.getDailyForecast("istanbul").enqueue(object: Callback<DailyForecastResponse> {
            override fun onFailure(call: Call<DailyForecastResponse>, t: Throwable) {
                Log.d("mh","response fail!")
            }

            override fun onResponse(call: Call<DailyForecastResponse>, response: Response<DailyForecastResponse>) {
                Log.e("mh","response success!")
                val body = response.body()


            }

        })
    }
}
