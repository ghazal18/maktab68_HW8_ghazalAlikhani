package com.example.myapplication

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityMain8Binding

object Game{
    var random0100 = 0
    var random010 = 0
    var leftOver = 0
    var num1 = 0
    var num2 = 0
    var num3 = 0
    var score = 0
    var cont = 0
}


class MainActivity8 : AppCompatActivity() {
    lateinit var binding: ActivityMain8Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)
        binding = ActivityMain8Binding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonsColor()
        binding.textViewScore.text = Game.score.toString()


        binding.button.setOnClickListener {
            binding.button2.isEnabled = true
            binding.button3.isEnabled = true
            binding.button4.isEnabled = true
            binding.button1.isEnabled = true


            if (Game.cont < 5) {
                genratRandomNumber()
                buttonsColor()
                Game.cont++
            } else {
                showDialog()
            }
        }
        binding.button1.setOnClickListener {
            binding.button2.isEnabled = false
            binding.button3.isEnabled = false
            binding.button4.isEnabled = false

            if (checkAnswer(binding.button1.text.toString())) {
                binding.button1.setBackgroundColor(Color.GREEN)
                Game.score += 5
                binding.textViewScore.text = Game.score.toString()

            } else {
                binding.button1.setBackgroundColor(Color.RED)
                Game.score -= 2
                binding.textViewScore.text = Game.score.toString()
            }
        }
        binding.button2.setOnClickListener {
            binding.button1.isEnabled = false
            binding.button3.isEnabled = false
            binding.button4.isEnabled = false
            if (checkAnswer(binding.button2.text.toString())) {
                binding.button2.setBackgroundColor(Color.GREEN)
                Game.score += 5
                binding.textViewScore.text = Game.score.toString()
            } else {
                binding.button2.setBackgroundColor(Color.RED)
                Game.score -= 2
                binding.textViewScore.text = Game.score.toString()
            }
        }
        binding.button3.setOnClickListener {
            binding.button2.isEnabled = false
            binding.button1.isEnabled = false
            binding.button4.isEnabled = false
            if (checkAnswer(binding.button3.text.toString())) {
                binding.button3.setBackgroundColor(Color.GREEN)
                Game.score += 5
                binding.textViewScore.text = Game.score.toString()
            } else {
                binding.button3.setBackgroundColor(Color.RED)
                Game.score -= 2
                binding.textViewScore.text = Game.score.toString()
            }
        }
        binding.button4.setOnClickListener {
            binding.button2.isEnabled = false
            binding.button3.isEnabled = false
            binding.button1.isEnabled = false
            if (checkAnswer(binding.button4.text.toString())) {
                binding.button4.setBackgroundColor(Color.GREEN)
                Game.score += 5
                binding.textViewScore.text = Game.score.toString()
            } else {
                binding.button4.setBackgroundColor(Color.RED)
                Game.score -= 2
                binding.textViewScore.text = Game.score.toString()
            }
        }


    }

    fun checkOption() {

        while (true) {
            Game.num1 = (1..9).random()
            if (Game.num1 != Game.leftOver) {
                break
            }
        }
        while (true) {
            Game.num2 = (1..9).random()
            if (Game.num2 != Game.leftOver && Game.num2 != Game.num1) {
                break
            }
        }
        while (true) {
            Game.num3 = (1..9).random()
            if (Game.num3 != Game.leftOver && Game.num3 != Game.num2 && Game.num3 != Game.num1) {
                break
            }
        }
    }

    fun genratRandomNumber() {
        Game.random0100 = (0..100).random()
        binding.random0100.text = Game.random0100.toString()
        Game.random010 = (1..9).random()
        binding.random010.text = Game.random010.toString()
        Game.leftOver = Game.random0100 % Game.random010
        checkOption()

        var random1_4 = (1..4).random()

        when (random1_4) {
            1 -> {
                binding.button1.text = Game.leftOver.toString()
                binding.button2.text = Game.num1.toString()
                binding.button3.text = Game.num2.toString()
                binding.button4.text = Game.num3.toString()
            }
            2 -> {
                binding.button2.text = Game.leftOver.toString()
                binding.button1.text = Game.num1.toString()
                binding.button3.text = Game.num2.toString()
                binding.button4.text = Game.num3.toString()
            }
            3 -> {
                binding.button3.text = Game.leftOver.toString()
                binding.button2.text = Game.num1.toString()
                binding.button1.text = Game.num2.toString()
                binding.button4.text = Game.num3.toString()
            }
            4 -> {
                binding.button4.text = Game.leftOver.toString()
                binding.button2.text = Game.num1.toString()
                binding.button3.text = Game.num2.toString()
                binding.button1.text = Game.num3.toString()
            }
        }
    }

    fun checkAnswer(textButton: String): Boolean {
        return textButton == Game.leftOver.toString()
    }

    fun buttonsColor() {
        binding.button1.setBackgroundColor(Color.GRAY)
        binding.button2.setBackgroundColor(Color.GRAY)
        binding.button3.setBackgroundColor(Color.GRAY)
        binding.button4.setBackgroundColor(Color.GRAY)
    }

    fun showDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
// set message of alert dialog
        dialogBuilder.setMessage(" امتیاز شما : ${Game.score}")
// if the dialog is cancelable
            .setCancelable(true)
// positive button text and action
            .setPositiveButton("تایید", DialogInterface.OnClickListener { dialog, id ->
                Game.random0100 = 0
                Game.random010 = 0
                Game.leftOver = 0
                Game.num1 = 0
                Game.num2 = 0
                Game.num3 = 0
                Game.score = 0
                Game.cont = 0

            })
            .setNegativeButton("خروج ", DialogInterface.OnClickListener {
                    dialog, id -> finish()
            })

// create dialog box
        val alert = dialogBuilder.create()
// set title for alert dialog box
        alert.setTitle("بازی تمام شد")
// show alert dialog
        alert.show()
    }


}