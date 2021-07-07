package com.example.waterdropcc.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.waterdropcc.data.UserModel

object UserComparator : DiffUtil.ItemCallback<UserModel>() {
    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        // Id is unique.
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem == newItem
    }
}