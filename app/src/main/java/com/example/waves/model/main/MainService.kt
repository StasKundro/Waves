package com.example.waves.model.main

class MainService: IMainService {
    override fun checkName(name: String) = name.isNotBlank()
    override fun checkEmail(email: String) = email.isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    override fun checkPassword(password: String, confirmPassword: String) = password.length >= 5 && password == confirmPassword
}