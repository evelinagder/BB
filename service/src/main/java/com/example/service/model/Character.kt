package com.example.service.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(val img: String?, val name: String?, val nickname: String?):Parcelable