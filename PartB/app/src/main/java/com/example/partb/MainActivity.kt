package com.example.partb

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val userInput = findViewById<EditText>(R.id.userInput)
        val button = findViewById<Button>(R.id.button)
        val result = findViewById<TextView>(R.id.result)

        button.setOnClickListener {
            var input = userInput.text.toString().trim()

            if (input.isEmpty()){
                result.text = "Przedstaw się."
            } else {
                result.text = "Witaj $input"
            }
        }
    }
}