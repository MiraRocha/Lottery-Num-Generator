package com.example.lotterynumgenerator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Declaring the Widgets
    private lateinit var editText: EditText
    private lateinit var titleTextView: TextView
    private lateinit var generateButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initializing the Widgets
        titleTextView = findViewById(R.id.textView)
        editText = findViewById(R.id.editTextName)
        generateButton = findViewById(R.id.generateBTN)

        generateButton.setOnClickListener {
            var name: String = editText.text.toString()

            //Explicit Intents
            var i = Intent(this, SecondActivity::class.java)
            i.putExtra("user name", name)
            startActivity(i)

        }

    }
}