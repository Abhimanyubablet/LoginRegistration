package com.example.loginregistration

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SologanSplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sologan_splash)

        Handler().postDelayed({
            startActivity(Intent(this,LoginActivity::class.java))

            val splashSharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
            val loginStatus = splashSharedPreferences.getBoolean("userlogin", false)
            if (loginStatus) {
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

        },2000)

    }
}