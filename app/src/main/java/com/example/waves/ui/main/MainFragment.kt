package com.example.waves.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.waves.ui.music.MusicFragment
import com.example.waves.MainActivity
import com.example.waves.R


import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private var needToOpenMusicFragment = false;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        button_sign_up.setOnClickListener {
            needToOpenMusicFragment = true
            viewModel.checkValues(editText_name.text.toString(), editText_email.text.toString(), editText_password.text.toString(), editText_confirm_password.text.toString())
        }
        subscribeOnLiveData()
    }
    private fun subscribeOnLiveData() {
        viewModel.isDataCorrect.observe(viewLifecycleOwner) {
            if (needToOpenMusicFragment) {
                if (it) {
                    (requireContext() as MainActivity).openFragment(MusicFragment())
                } else {
                    Toast.makeText(
                        requireContext(),
                        resources.getString(R.string.something_is_wrong),
                        Toast.LENGTH_LONG
                    ).show()
                }
                needToOpenMusicFragment = false
            }
        }
    }
}
