package com.example.loginregistration

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class StudentProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var rowView= inflater.inflate(R.layout.fragment_student_profile, container, false)

        val sharedPreferences = activity?.getSharedPreferences("userPref", Context.MODE_PRIVATE)
        val name =rowView. findViewById<TextView>(R.id.Text_name)
        val mobile= rowView.findViewById<TextView>(R.id.Text_mobile)
        val mail = rowView.findViewById<TextView>(R.id.Text_mail)
        val pass = rowView.findViewById<TextView>(R.id.Text_pass)

        name.text = sharedPreferences?.getString("name", "").toString()
        mobile.text = sharedPreferences?.getString("mobile", "").toString()
        mail.text = sharedPreferences?.getString("mail", "").toString()
        pass.text = sharedPreferences?.getString("pass", "").toString()
        return rowView
    }


}