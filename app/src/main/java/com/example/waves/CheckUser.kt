package com.example.waves

interface CheckUser {
        fun checkName(name: String): Boolean
        fun checkEmail(email: String): Boolean
        fun checkPassword(password: String, confirmPassword: String): Boolean
}