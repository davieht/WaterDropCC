package com.example.waterdropcc.detail

import androidx.lifecycle.*
import com.example.waterdropcc.data.UserModel
import com.example.waterdropcc.data.UserRepo

class DetailViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val userRepo: UserRepo
) : ViewModel(){
    val user : LiveData<UserModel> = savedStateHandle.getLiveData<String>("userId").switchMap { userId ->
        liveData {
            emit(userRepo.getUser(userId))
        }
    }

    fun setUserId(userId: String?) {
        savedStateHandle["userId"] = userId
    }
}