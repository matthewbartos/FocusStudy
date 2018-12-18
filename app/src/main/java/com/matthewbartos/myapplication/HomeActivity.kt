package com.matthewbartos.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        openHomeFragment()

        nav_home_btn.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                Toast.makeText(this, "HOME", Toast.LENGTH_SHORT).show()
                openHomeFragment()
            }
        }

        nav_fitness_btn.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                Toast.makeText(this, "FITNESS", Toast.LENGTH_SHORT).show()
                openFitnessFragment()
            }
        }

        nav_nutrition_btn.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                Toast.makeText(this, "NUTRITION", Toast.LENGTH_SHORT).show()
                openNutritionFragment()
            }
        }
    }

    private fun openNutritionFragment() {
        val fragment = supportFragmentManager.findFragmentByTag(NutritionFragment.TAG) ?: NutritionFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment, NutritionFragment.TAG)
            .addToBackStack(null)
            .commit()
    }

    private fun openHomeFragment() {
        val fragment = supportFragmentManager.findFragmentByTag(HomeFragment.TAG) ?: HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment, HomeFragment.TAG)
            .addToBackStack(null)
            .commit()
    }

    private fun openFitnessFragment() {
        val fragment = supportFragmentManager.findFragmentByTag(FitnessFragment.TAG) ?: FitnessFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment, FitnessFragment.TAG)
            .addToBackStack(null)
            .commit()
    }

}
