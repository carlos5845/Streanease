package com.miaplicaion.mycard.data.model

import android.os.Parcel
import android.os.Parcelable

data class Card(
    val amount: String,
    val name: String,
    val description: String,
    val dueDate: String,
    val paymentMethod: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(amount)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(dueDate)
        parcel.writeString(paymentMethod)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Card> {
        override fun createFromParcel(parcel: Parcel): Card {
            return Card(parcel)
        }

        override fun newArray(size: Int): Array<Card?> {
            return arrayOfNulls(size)
        }
    }
}
