package com.example.session8_islami.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.session8_islami.R
import com.example.session8_islami.ahadeth.Hadeth_fragment
import com.example.session8_islami.quran.QuranFragment
import com.example.session8_islami.sebha.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var buttonNavigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        buttonNavigationView = findViewById(R.id.button_navigation_bar)

        buttonNavigationView.selectedItemId = R.id.navigation_quran
        pushFragment(QuranFragment())

        buttonNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_quran -> {
                    pushFragment(QuranFragment())
                }
                R.id.navigation_hadeth -> {
                    pushFragment(Hadeth_fragment())
                }
                R.id.navigation_sebha -> {
                    pushFragment(SebhaFragment())
                }
            }

            return@setOnItemSelectedListener true
        }

    }

    private fun pushFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()
    }
}