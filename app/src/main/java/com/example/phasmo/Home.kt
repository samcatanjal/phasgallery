package com.example.phasmo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class Home : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var bottomNavigationView : BottomNavigationView
    private lateinit var viewPager: ViewPager2
    private lateinit var topAppBar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        viewPager = findViewById(R.id.viewPager)
        topAppBar = findViewById(R.id.topAppBar)

        setSupportActionBar(topAppBar)

        val adapter = HomePagerAdapter(this)
        viewPager.adapter = adapter

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_ghosts -> viewPager.setCurrentItem(0, true)
                R.id.navigation_cursed_possessions -> viewPager.setCurrentItem(1, true)
                R.id.navigation_equipment -> viewPager.setCurrentItem(2, true)
            }
            true
        }
        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_user -> {
                    showUserDialog()
                    true
                }
                else -> false
            }
        }
    }

    private fun showUserDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("User Info")
            .setMessage("Hello, ${sharedPreferences.getString("username", "")}") // Retrieve actual username
            .setPositiveButton("Logout") { dialog, _ ->
                logout()
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun logout() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()

        val intent = Intent(this, Login::class.java)
        startActivity(intent)
        finish()
        Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu) //
        return true
    }
}