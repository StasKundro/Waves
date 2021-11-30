package com.example.waves

class Model {
    fun checkName(name: String) = name.isNotBlank()
    fun checkEmail(email: String) = email.isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    fun checkPassword(password: String, confirmPassword: String) = password.length >= 5 && password == confirmPassword
}