package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.text.isDigitsOnly
import com.example.myapplication.databinding.ActivityMain7Binding

class MainActivity7 : AppCompatActivity() {
    lateinit var binding : ActivityMain7Binding
    lateinit var sp : SharedPreferences
//    lateinit var radioButton: RadioButton
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)
        binding = ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSetInfo.setOnClickListener(::setInformation)
        sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE)
        editor =  sp.edit()
        changeInfo()
    }

    private fun setInformation(view: View?) {
        setErrorsForID()
        setErrorsForPostID()
        setErrorSForEmptyfield()
        saveInformation()
        if (setErrorSForEmptyfield() && setErrorsForPostID() && setErrorsForID()){
            goToNextPage()
        }


    }

    private fun saveInformation() {
        editor.putString("name",binding.editTextTextPersonName.text.toString())
        editor.putString("id",binding.editTextTextPersonid2.text.toString())
        editor.putString("birthday",binding.editTextTextPersonDate3.text.toString())
        editor.putString("address",binding.editTextTextPersonAddress4.text.toString())
        editor.putString("postId",binding.editTextTextPersonPostId5.text.toString())
        editor.apply()
    }


    private fun setErrorSForEmptyfield():Boolean{

        if(binding.editTextTextPersonName.text.isNullOrBlank()){
            binding.editTextTextPersonName.error ="please enter name"
            return false
        }
        if(binding.editTextTextPersonid2.text.isNullOrBlank()){
            binding.editTextTextPersonid2.error ="please enter ID number"
            return false
        }
        if(binding.editTextTextPersonDate3.text.isNullOrBlank()){
            binding.editTextTextPersonDate3.error ="please enter birthday place"
            return false
        }
        if(binding.editTextTextPersonAddress4.text.isNullOrBlank()){
            binding.editTextTextPersonAddress4.error ="please enter address"
            return false
        }
        if(binding.editTextTextPersonPostId5.text.isNullOrBlank()){
            binding.editTextTextPersonPostId5.error ="please enter post ID"
            return false
        }
        return true
    }

    private fun setErrorsForID():Boolean {
        var isNumber = binding.editTextTextPersonid2.text.isDigitsOnly()
        var lenght = binding.editTextTextPersonid2.text.length
        if (!isNumber || lenght != 10){
            binding.editTextTextPersonid2.error = "please enter 10 numbers"
            return false
        }
        return true
    }
    private fun setErrorsForPostID():Boolean {
        var isNumber = binding.editTextTextPersonPostId5.text.isDigitsOnly()
        if (!isNumber){
            binding.editTextTextPersonPostId5.error = "please enter numbers"
            return false
        }
        return true
    }
    fun  goToNextPage(){
        val intent = Intent(this,MainActivity9::class.java)
        startActivity(intent)
    }

    fun changeInfo(){
        binding.editTextTextPersonid2.setText(sp.getString("id", ""))
        binding.editTextTextPersonAddress4.setText (sp.getString("address", ""))
        binding.editTextTextPersonPostId5.setText (sp.getString("postId", ""))
        binding.editTextTextPersonDate3.setText(sp.getString("birthday", ""))
        binding.editTextTextPersonName.setText(sp.getString("name", ""))
        saveInformation()

    }
}