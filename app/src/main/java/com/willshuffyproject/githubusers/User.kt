package com.willshuffyproject.githubusers

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class User (
    val username: String?= "",
    val name: String?= "",
    val profpict: Int,
    val company: String?= "",
    val location: String?= "",
    val repository: String?= "",
    val follower: String?= "",
    val following: String?= ""
): Parcelable