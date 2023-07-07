package com.example.loginregistration

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class UserRegistrationPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_registration_page)

        val  editName = findViewById<EditText>(R.id.edit_name)
        val editNumber = findViewById<EditText>(R.id.edit_number)
        val  editEmail = findViewById<EditText>(R.id.edit_mail)
        val  editPass = findViewById<EditText>(R.id.edit_pass)
        val signUp=findViewById<Button>(R.id.signup_btn)


        val sharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
        val editProof = sharedPreferences.edit()
        signUp.setOnClickListener {
            editProof.putBoolean("userlogin", true)
            editProof.apply()
            editProof.putString("name", editName.text.toString())
            editProof.putString("mobile",editNumber.text.toString())
            editProof.putString("mail", editEmail.text.toString())
            editProof.putString("pass",editPass.text.toString()).apply()
            startActivity(Intent(this,DashboardActivity::class.java))
        }

    }
}