package com.example.waves.model.main

interface IMainService {
    fun checkName(name: String): Boolean
    fun checkEmail(email: String): Boolean
    fun checkPassword(password: String, confirmPassword: String): Boolean
}