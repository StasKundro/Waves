package com.example.waves.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.waves.CheckUser

class ViewModel : ViewModel(){
    private val model: CheckUser = Model()

    val isDataCorrect = MutableLiveData<Boolean>()

    fun checkValues(name: String, email: String, password: String, confirmPassword: String){
        isDataCorrect.postValue(model.checkName(name) && model.checkEmail(email) && model.checkPassword(password, confirmPassword))
    }
}