package com.sahibindencourseproject3.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.sahibindencourseproject3.R


/**
 * Created by Ataer Caner on 2020-01-30.
Copyright (c) 2020 sahibinden. All rights reserved.
 *
 */

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activiy_splash)
        navigateToMain()
    }

    fun navigateToMain() {
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        },1500)
    }

}