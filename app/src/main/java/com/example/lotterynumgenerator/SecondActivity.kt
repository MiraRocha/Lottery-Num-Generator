package com.example.lotterynumgenerator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    // Declaring the Views
    private lateinit var textViewTitle: TextView
    private lateinit var textGeneratedNumbers: TextView
    private lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        // Initializing the Views
        textViewTitle = findViewById(R.id.textView2)
        textGeneratedNumbers = findViewById(R.id.resultTextView)
        shareButton = findViewById(R.id.shareBTN)

        // Generate 6 random numbers and store them in a string
        val randomNumbers = generateRandomNumbers(6)
        textGeneratedNumbers.text = randomNumbers

        // Getting the Username from de main Activity
        val username = receiveUserName()

        // Sharing the username & generated Numbers with Email App
        shareButton.setOnClickListener {
            shareResult(username, randomNumbers)
        }
    }

    fun generateRandomNumbers(count:Int): String {
        val randomNumbers = List(count){
            // lambda expression to generate random numbers
            (0..42).random()
        }
        // Convert the list of numbers to a string
        return randomNumbers.joinToString( " ")
    }

    fun receiveUserName():String{
        // retrieve the extras that were added to an INTENT
        val bundle:Bundle? = intent.extras

        // Give me the key, I'll give you the value
        val userName = bundle?.getString("username").toString()

        return userName
    }

    fun shareResult(username:String, generateNums:String){

        // Implicit Intents: specify an action to be performed
        // and the system determine the appropriate component
        // to handle that action based on the available registered
        // component and their declared capabilities

        // Sending data to another application
        val i = Intent(Intent.ACTION_SEND)
        
        i.type = "text/plain"
        i.putExtra(Intent.EXTRA_SUBJECT, "$username generates these numbers")
        i.putExtra(Intent.EXTRA_TEXT, " The Lottery Numbers are: $generateNums")
        startActivity(i)

    }

}