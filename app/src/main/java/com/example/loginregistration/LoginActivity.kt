package com.example.loginregistration

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signUpTextView=findViewById<TextView>(R.id.text_signup)
        val editUsername=findViewById<EditText>(R.id.edit_username)
        val editPassword=findViewById<EditText>(R.id.edit_password)
        val loginBtn=findViewById<Button>(R.id.login_btn)

        val registerSharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
        val userName=registerSharedPreferences.getString("name","")
        val userPass=registerSharedPreferences.getString("pass","")

        signUpTextView.setOnClickListener{
            startActivity(Intent(this,UserRegistrationPageActivity::class.java))
        }

        loginBtn.setOnClickListener {
            val user: String = editUsername.text.toString()
            val pass: String = editPassword.text.toString()
            if (userName==user && userPass==pass) {
                val edit = registerSharedPreferences.edit()
                edit.putBoolean("userlogin", true)
                edit.apply()
                val intent = Intent(this,DashboardActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(getApplicationContext(), "Username/Password Invalid", Toast.LENGTH_LONG).show();
            }
        }
    }



}