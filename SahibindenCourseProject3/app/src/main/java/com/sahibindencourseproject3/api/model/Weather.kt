package com.sahibindencourseproject3.api.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Weather() : Parcelable {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("main")
    @Expose
    var main: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("icon")
    @Expose
    var icon: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        main = parcel.readString()
        description = parcel.readString()
        icon = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(main)
        parcel.writeString(description)
        parcel.writeString(icon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Weather> {
        override fun createFromParcel(parcel: Parcel): Weather {
            return Weather(parcel)
        }

        override fun newArray(size: Int): Array<Weather?> {
            return arrayOfNulls(size)
        }
    }


}
