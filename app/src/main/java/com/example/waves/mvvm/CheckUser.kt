package com.example.waves.mvvm

interface CheckUser {
    fun checkName(name: String): Boolean
    fun checkEmail(email: String): Boolean
    fun checkPassword(password: String, confirmPassword: String): Boolean
}