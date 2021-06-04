package com.example.myselfapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myselfapp.databinding.ActivityMainBinding

/**
 *
 * =========================================================================================
 * This project was created to fulfill the Midterm Exam of Mobile Computing Application course.
 *
 *                              Universitas Komputer Indonesia
 * =========================================================================================
 *
 * Author's Information
 * ==========================
 * NIM      : 10118902
 * Name     : Agung Sepruloh
 * Class    : IF-11
 * Informatics Engineering
 * ==========================
 * Created on  04 Jun 2021
 *
 */
class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}