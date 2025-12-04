package com.example.mpib // Ensure this package name matches your project structure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // This loads the layout with the FrameLayout container

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set the default fragment when the app starts
        loadFragment(HomeFragment())

        // Set up the listener for the bottom navigation bar
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_stock -> {
                    loadFragment(StockFragment())
                    true
                }
                R.id.nav_entrepreneurs -> {
                    loadFragment(EntrepreneursFragment())
                    true
                }
                R.id.nav_news -> {
                    loadFragment(NewsFragment())
                    true
                }
                R.id.nav_info -> {
                    loadFragment(InfoFragment())
                    true
                }
                else -> false
            }
        }
    }

    /**
     * Helper function to replace the content of the fragment_container
     */
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}