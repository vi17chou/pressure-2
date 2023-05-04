package com.example.mainactivity.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


class A(application: Application):AndroidViewModel(application) {
    private val readAllData:LiveData<List<User>>
    private val repository: UserRepository
    init {
        val userDao=UserDatabase.getDatabase(application).UserDao()
        repository= UserRepository(userDao)
        readAllData=repository.readAllData
    }

}