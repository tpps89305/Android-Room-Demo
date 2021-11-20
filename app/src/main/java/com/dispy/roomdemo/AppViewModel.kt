package com.dispy.roomdemo

import androidx.lifecycle.*
import kotlinx.coroutines.launch

/**
 * Created by tpps8 on 2021/11/20
 *
 */
class AppViewModel(private val repository: AppRepository): ViewModel() {

    val allUsers: LiveData<List<User>> = repository.allUsers.asLiveData()

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }

}

class AppViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)) {
            return AppViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}