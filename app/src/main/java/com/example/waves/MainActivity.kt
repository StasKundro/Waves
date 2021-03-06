package com.example.waves

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.waves.model.storage.AppPreferences
import com.example.waves.ui.main.MainFragment
import com.example.waves.ui.music.MusicFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            if (AppPreferences.getInstance(this).getToken().isBlank()){
                openFragment(MainFragment())
            }else{
                openFragment(MusicFragment())
            }
        }
    }
    fun openFragment(fragment: Fragment){
        supportFragmentManager.commit {
            setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.slide_in_back,
                R.anim.slide_out_back
            )
            replace(R.id.main_fragment_container, fragment, fragment.toString())
            addToBackStack(null)
        }
    }
    override fun onBackPressed() {
        val fragmentCount = supportFragmentManager.backStackEntryCount
        if (fragmentCount > 1) {
            super.onBackPressed()
        } else {
            finish()
        }
    }
}