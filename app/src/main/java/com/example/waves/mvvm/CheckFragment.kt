package com.example.waves.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.waves.MainActivity
import com.example.waves.R
import com.example.waves.Success
import com.google.android.material.textfield.TextInputEditText

class CheckFragment : Fragment() {

    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mvvm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        val button: AppCompatButton = view.findViewById(R.id.button_sign_up)
        val nik: TextInputEditText = view.findViewById(R.id.editText_name)
        val mail: TextInputEditText = view.findViewById(R.id.editText_email)
        val pass: TextInputEditText = view.findViewById(R.id.editText_password)
        val confirmPass: TextInputEditText = view.findViewById(R.id.editText_confirm_password)

        button.setOnClickListener {
            val lay1 = nik.text.toString()
            val lay2 = mail.text.toString()
            val lay3 = pass.text.toString()
            val lay4 = confirmPass.text.toString()
            viewModel.checkValues(lay1, lay2, lay3, lay4)
        }
        subscribeOnLiveData()
    }

    private fun subscribeOnLiveData() {
        viewModel.isDataCorrect.observeForever {
            if (it) {
                (requireContext() as MainActivity).openFragment(Success())
            } else {
                Toast.makeText(requireContext(), "Something wrong", Toast.LENGTH_LONG).show()
            }
        }
    }
}