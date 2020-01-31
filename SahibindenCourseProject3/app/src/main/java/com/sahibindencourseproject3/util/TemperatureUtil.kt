package com.sahibindencourseproject3.util

import kotlin.math.roundToInt

/**
 * Created by Ataer Caner on 2019-12-02.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

class TemperatureUtil {

    companion object {
        @JvmStatic
        fun getCelcius(temp: Double?): String {
            temp ?: return ""
            return temp.roundToInt().toString() + "°"
        }
    }
}
