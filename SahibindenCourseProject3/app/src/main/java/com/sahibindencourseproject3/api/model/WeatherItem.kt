package com.sahibindencourseproject3.api.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sahibindencourseproject3.api.model.Temp
import com.sahibindencourseproject3.api.model.Weather

class WeatherItem() : Parcelable {

    @SerializedName("dt")
    @Expose
    var dt: Int? = null
    @SerializedName("sunrise")
    @Expose
    var sunrise: Int? = null
    @SerializedName("sunset")
    @Expose
    var sunset: Int? = null
    @SerializedName("temp")
    @Expose
    var temp: Temp? = null
    @SerializedName("pressure")
    @Expose
    var pressure: Int? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null
    @SerializedName("weather")
    @Expose
    var weather: List<Weather>? = null
    @SerializedName("speed")
    @Expose
    var speed: Double? = null
    @SerializedName("deg")
    @Expose
    var deg: Int? = null
    @SerializedName("clouds")
    @Expose
    var clouds: Int? = null
    @SerializedName("rain")
    @Expose
    var rain: Double? = null

    constructor(parcel: Parcel) : this() {
        dt = parcel.readValue(Int::class.java.classLoader) as? Int
        sunrise = parcel.readValue(Int::class.java.classLoader) as? Int
        sunset = parcel.readValue(Int::class.java.classLoader) as? Int
        temp = parcel.readParcelable(Temp::class.java.classLoader)
        pressure = parcel.readValue(Int::class.java.classLoader) as? Int
        humidity = parcel.readValue(Int::class.java.classLoader) as? Int
        weather = parcel.createTypedArrayList(Weather)
        speed = parcel.readValue(Double::class.java.classLoader) as? Double
        deg = parcel.readValue(Int::class.java.classLoader) as? Int
        clouds = parcel.readValue(Int::class.java.classLoader) as? Int
        rain = parcel.readValue(Double::class.java.classLoader) as? Double
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(dt)
        parcel.writeValue(sunrise)
        parcel.writeValue(sunset)
        parcel.writeParcelable(temp, flags)
        parcel.writeValue(pressure)
        parcel.writeValue(humidity)
        parcel.writeTypedList(weather)
        parcel.writeValue(speed)
        parcel.writeValue(deg)
        parcel.writeValue(clouds)
        parcel.writeValue(rain)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherItem> {
        override fun createFromParcel(parcel: Parcel): WeatherItem {
            return WeatherItem(parcel)
        }

        override fun newArray(size: Int): Array<WeatherItem?> {
            return arrayOfNulls(size)
        }
    }

}
