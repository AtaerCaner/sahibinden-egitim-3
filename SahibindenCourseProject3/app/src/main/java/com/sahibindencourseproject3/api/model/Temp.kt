package com.sahibindencourseproject3.api.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Temp() : Parcelable{

    @SerializedName("day")
    @Expose
    var day: Double? = null
    @SerializedName("min")
    @Expose
    var min: Double? = null
    @SerializedName("max")
    @Expose
    var max: Double? = null
    @SerializedName("night")
    @Expose
    var night: Double? = null
    @SerializedName("eve")
    @Expose
    var eve: Double? = null
    @SerializedName("morn")
    @Expose
    var morn: Double? = null

    constructor(parcel: Parcel) : this() {
        day = parcel.readValue(Double::class.java.classLoader) as? Double
        min = parcel.readValue(Double::class.java.classLoader) as? Double
        max = parcel.readValue(Double::class.java.classLoader) as? Double
        night = parcel.readValue(Double::class.java.classLoader) as? Double
        eve = parcel.readValue(Double::class.java.classLoader) as? Double
        morn = parcel.readValue(Double::class.java.classLoader) as? Double
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(day)
        parcel.writeValue(min)
        parcel.writeValue(max)
        parcel.writeValue(night)
        parcel.writeValue(eve)
        parcel.writeValue(morn)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Temp> {
        override fun createFromParcel(parcel: Parcel): Temp {
            return Temp(parcel)
        }

        override fun newArray(size: Int): Array<Temp?> {
            return arrayOfNulls(size)
        }
    }

}
