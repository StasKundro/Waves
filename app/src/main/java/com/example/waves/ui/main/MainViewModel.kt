package com.example.waves.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.waves.model.main.IMainService
import com.example.waves.model.main.MainService
import com.example.waves.model.storage.IAppPreferences

class MainViewModel: ViewModel() {
    private val model: IMainService = MainService()
    private var preferences: IAppPreferences? = null

    val emailLiveData = MutableLiveData<String>()
    val loginLiveData = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()
    val saveCredentialsCheckedLiveData = MutableLiveData<Boolean>()

    val isDataCorrect = MutableLiveData<Boolean>()

    fun checkValues(name: String, email: String, password: String, confirmPassword: String, saveCredentials: Boolean){
        val valuesAreCorrect = model.checkName(name) && model.checkEmail(email) && model.checkPassword(password, confirmPassword)
        isDataCorrect.postValue(valuesAreCorrect)
        if (saveCredentials && valuesAreCorrect) {
            saveCredentials(name, email, password)
            saveToken("$name, $email, $password")
        }
    }
    fun setSharedPreferences(preferences: IAppPreferences) {
        this.preferences = preferences
    }
    fun setSaveCredentialsSelected(isSelected: Boolean) {
        preferences?.setSaveCredentialsSelected(isSelected)
    }
    fun fetchStoredData() {
        preferences?.let {
            if (it.isSaveCredentialsSelected()) {
                loginLiveData.postValue(it.getLogin())
                emailLiveData.postValue(it.getEmail())
                passwordLiveData.postValue(it.getPassword())
                saveCredentialsCheckedLiveData.postValue(true)
            }
        }
    }
    private fun saveCredentials(login: String, email: String, password: String) {
        preferences?.let {
            if (it.isSaveCredentialsSelected()) {
                it.saveLogin(login)
                it.saveEmail(email)
                it.savePassword(password)
            }
        }
    }
    private fun saveToken(token: String) {
        preferences?.saveToken(token)
    }
}