package com.example.loginregistration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_page)
        val navigationBtn=findViewById<BottomNavigationView>(R.id.student_navigation_view)
        val logoutBtn=findViewById<Button>(R.id.logout_btn)


        navigationBtn.setOnItemSelectedListener {
            when (it.itemId){
                R.id.student_bottom_home -> loadFragment(StudentHomeFragment())
                R.id.student_bottom_setting -> loadFragment(StudentSettingFragment())
                R.id.student_bottom_profile -> loadFragment(StudentProfileFragment())

            }
            true
        }

        logoutBtn.setOnClickListener {
            val sharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
            val editUserPref = sharedPreferences.edit()
            editUserPref.putBoolean("userlogin", false)
            editUserPref.apply()
            startActivity(Intent(this,LoginActivity::class.java))

        }


    }

    private fun loadFragment (fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.student_framelaout,fragment).commit()
    }
}

