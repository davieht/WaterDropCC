package com.example.waterdropcc.main

import androidx.recyclerview.widget.RecyclerView
import com.example.waterdropcc.data.UserModel
import com.example.waterdropcc.databinding.ListItemUserBinding

class UserViewHolder(private val binding: ListItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: UserModel) {
        binding.user = user
    }
}