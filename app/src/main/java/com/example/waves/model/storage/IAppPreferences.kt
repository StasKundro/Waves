package com.example.waves.model.storage

interface IAppPreferences {
    fun isSaveCredentialsSelected(): Boolean
    fun setSaveCredentialsSelected(isSelected: Boolean)

    fun saveLogin(login: String)
    fun saveEmail(email: String)
    fun savePassword(password: String)
    fun getLogin(): String
    fun getEmail(): String
    fun getPassword(): String

    fun saveToken(token: String)
    fun getToken(): String
}