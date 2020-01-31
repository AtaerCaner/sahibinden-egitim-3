package com.sahibindencourseproject3.util

import java.util.Calendar

/**
 * Created by Ataer Caner on 2019-12-02.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

class DateUtil {
    companion object {
        private val days =
                arrayOf("Pazartesi", "Salı", "Carsamba", "Persembe", "Cuma", "Cumartesi", "Pazar")

        @JvmStatic
        val todaysDayOfWeekAsIndex: Int
        get() {
            val c = Calendar.getInstance()
            return c.get(Calendar.DAY_OF_WEEK) - 1
        }

        @JvmStatic
        val todaysDayOfWeekAsName: String
        get() = getGivenDayOfWeekAsName(todaysDayOfWeekAsIndex)

        @JvmStatic
        fun getGivenDayOfWeekAsName(index: Int): String {
            return days[index]
        }
    }
}
