package com.example.partc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var generatedNumber = 0
    var attempts = 0
    var gameActive = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val userNumber = findViewById<EditText>(R.id.userNumber)
        val checkButton = findViewById<Button>(R.id.checkButton)
        val messageView = findViewById<TextView>(R.id.display)
        val attemptCounter = findViewById<TextView>(R.id.attemptCounter)

        startNewGame(messageView, attemptCounter)

        checkButton.setOnClickListener {
            if (!gameActive) return@setOnClickListener

            val guess = (userNumber.text.toString()).toIntOrNull()

            if (guess == null) {
                messageView.text = "Please enter an integer number."
                return@setOnClickListener
            }
            if (guess !in 1..10) {
                messageView.text = "Number must be in range 1..10."
                return@setOnClickListener
            }

            attempts++
            attemptCounter.text = "Attempt: $attempts"


            when {
                guess < generatedNumber -> {
                    messageView.text = "Value too small"
                }
                guess > generatedNumber -> {
                    messageView.text = "Value too large"
                }
                else -> {
                    if (attempts == 2) {
                        messageView.text = "Correct — achieved on the 2nd attempt"
                        gameActive = false // Game Ends
                        checkButton.isEnabled = false
                    } else {
                        messageView.text = "Correct, but not on the 2nd attempt. Try again."
                        startNewGame(messageView, attemptCounter)
                    }
                }
            }
            userNumber.text.clear()
        }

    }

    private fun startNewGame(message: TextView, label: TextView) {
        generatedNumber = Random.nextInt(1, 11)
        attempts = 0
        label.text = "Attempt: 1"
    }
}