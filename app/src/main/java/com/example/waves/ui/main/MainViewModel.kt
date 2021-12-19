package com.example.waves.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.waves.model.main.IMainService
import com.example.waves.model.main.MainService

class MainViewModel: ViewModel() {
    private val model: IMainService = MainService()

    val isDataCorrect = MutableLiveData<Boolean>()

    fun checkValues(name: String, email: String, password: String, confirmPassword: String){
        isDataCorrect.postValue(model.checkName(name) && model.checkEmail(email) && model.checkPassword(password, confirmPassword))
    }
}