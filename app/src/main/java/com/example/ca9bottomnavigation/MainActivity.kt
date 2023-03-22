package com.example.ca9bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ca9bottomnavigation.fragments.ChartFragment
import com.example.ca9bottomnavigation.fragments.HomeFragment
import com.example.ca9bottomnavigation.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val chartFragment = ChartFragment()
        val settingsFragment = SettingsFragment()

        changeFragment(homeFragment)

        findViewById<BottomNavigationView>(R.id.bottom_nav).setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.ic_home ->{
                    changeFragment(homeFragment)
                    true
                }
                R.id.ic_chart ->{
                    changeFragment(chartFragment)
                    true
                }
                R.id.ic_settings->{
                    changeFragment(settingsFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fContainer,fragment)
            commit()
        }
    }
}