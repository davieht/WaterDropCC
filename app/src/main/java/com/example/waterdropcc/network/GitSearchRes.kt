package com.example.waterdropcc.network

import com.example.waterdropcc.data.UserModel
import com.google.gson.annotations.SerializedName

data class GitSearchRes(
    @SerializedName("totalCount")
    val totalCount: Int,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    val items: List<UserModel>
)