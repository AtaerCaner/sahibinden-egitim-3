package com.sahibindencourseproject3.api.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coord() :Parcelable {

    @SerializedName("lon")
    @Expose
    var lon: Double? = null
    @SerializedName("lat")
    @Expose
    var lat: Double? = null

    constructor(parcel: Parcel) : this() {
        lon = parcel.readValue(Double::class.java.classLoader) as? Double
        lat = parcel.readValue(Double::class.java.classLoader) as? Double
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(lon)
        parcel.writeValue(lat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coord> {
        override fun createFromParcel(parcel: Parcel): Coord {
            return Coord(parcel)
        }

        override fun newArray(size: Int): Array<Coord?> {
            return arrayOfNulls(size)
        }
    }

}
