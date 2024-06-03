package com.example.phasmo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Signup : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var newUsername: EditText
    private lateinit var newPassword: EditText
    private lateinit var newSignupButton: Button
    private lateinit var backButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        newUsername = findViewById(R.id.newUsername)
        newPassword = findViewById(R.id.newPassword)
        newSignupButton = findViewById(R.id.newSignupButton)
        backButton = findViewById(R.id.backButton)

        newSignupButton.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("username", newUsername.text.toString())
            editor.putString("password", newPassword.text.toString())
            editor.apply()

            Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show()
            finish()
        }

        backButton.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

    }
}