package com.example.waves

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel(){
    private val model = Model()

    val isDataCorrect = MutableLiveData<Boolean>()

    fun checkValues(name: String, email: String, password: String, confirmPassword: String){
        isDataCorrect.postValue(model.checkName(name) && model.checkEmail(email) && model.checkPassword(password, confirmPassword))
    }
}