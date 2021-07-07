package com.example.waterdropcc.main

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.waterdropcc.data.UserRepo

class MainViewModelFactory(
    private val owner: SavedStateRegistryOwner,
    private val repo: UserRepo
) : AbstractSavedStateViewModelFactory(owner, null) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return MainViewModel(handle, repo) as T
    }
}