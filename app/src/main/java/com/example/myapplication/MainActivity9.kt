package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMain7Binding
import com.example.myapplication.databinding.ActivityMain9Binding

class MainActivity9 : AppCompatActivity() {
    lateinit var binding: ActivityMain9Binding
    lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)
        binding = ActivityMain9Binding.inflate(layoutInflater)
        setContentView(binding.root)
        sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE)

        showInfoWhenPageOpen()
        binding.changeInfo.setOnClickListener(::changeInfoButton)

    }

    private fun changeInfoButton(view: View?) {
        val intent = Intent(this,MainActivity7::class.java)
        startActivity(intent)
    }

    private fun showInfoWhenPageOpen() {
        var id = sp.getString("id", "")
        var address = sp.getString("address", "")
        var postCode = sp.getString("postId", "")
        var gender = sp.getString("gender", "")
        var birthday = sp.getString("birthday","")
        binding.showId.text = "${binding.showId.text} $id"
        binding.showAddress.text = "${binding.showAddress.text} $address"
        binding.showPostCode.text = "${binding.showPostCode.text} $postCode"
        binding.showGender.text = "${binding.showGender.text} $gender"
        binding.showBirthday.text = "${binding.showBirthday.text} $birthday"
    }
}