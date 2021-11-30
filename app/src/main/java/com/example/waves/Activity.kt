package com.example.waves

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Activity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        val button: AppCompatButton = findViewById(R.id.button_sign_up)
        val nik: TextInputEditText = findViewById(R.id.editText_name)
        val mail: TextInputEditText = findViewById(R.id.editText_email)
        val pass: TextInputEditText = findViewById(R.id.editText_password)
        val confirmPass: TextInputEditText = findViewById(R.id.editText_confirm_password)

        button.setOnClickListener {
            val lay1 = nik.text.toString()
            val lay2 = mail.text.toString()
            val lay3 = pass.text.toString()
            val lay4 = confirmPass.text.toString()
            viewModel.checkValues(lay1,lay2,lay3,lay4)
        }
        subscribeOnLiveData()
    }
    private fun subscribeOnLiveData() {
        viewModel.isDataCorrect.observeForever {
            if (it){
                val intent = Intent(this, Success::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Something is wrong", Toast.LENGTH_LONG).show()
            }
        }
    }
}