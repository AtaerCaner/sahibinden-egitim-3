package com.sahibindencourseproject3.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlin.math.roundToInt


/**
 * Created by Ataer Caner on 2020-01-31.
Copyright (c) 2020 sahibinden. All rights reserved.
 *
 */

fun FragmentManager.addToCommit(resourceId: Int, fragment: Fragment) {
    this.beginTransaction().add(resourceId,fragment).commit()
}

fun Double.toCelcius(): String = this.roundToInt().toString() + "°"

fun String.toIconUrl(): String {
    return "http://openweathermap.org/img/wn/$this@2x.png"
}