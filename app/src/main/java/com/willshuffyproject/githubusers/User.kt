package com.willshuffyproject.githubusers

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class User (
    var username: String,
    var name: String,
    var profpict: Int,
    var company: String,
    var location: String,
    var repository: String,
    var follower: String,
    var following: String
): Parcelable