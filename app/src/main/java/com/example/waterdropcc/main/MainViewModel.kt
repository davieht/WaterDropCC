package com.example.waterdropcc.main

import androidx.lifecycle.*
import com.example.waterdropcc.data.UserModel
import com.example.waterdropcc.data.UserRepo

class MainViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val userRepo: UserRepo
) : ViewModel() {

    val users: LiveData<List<UserModel>> = savedStateHandle.getLiveData<String>("query").switchMap { query ->
        liveData {
            emit(userRepo.getUsers(query))
        }
    }

    fun setQuery(query: String) {
        savedStateHandle["query"] = query
    }
}