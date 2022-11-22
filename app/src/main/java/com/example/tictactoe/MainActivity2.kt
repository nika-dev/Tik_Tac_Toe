package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity2 : AppCompatActivity() {
    private lateinit var Player1: EditText
    private lateinit var Player2: EditText
    private lateinit var Button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Player1 = findViewById(R.id.first)
        Player2 = findViewById(R.id.second)
        Button = findViewById(R.id.start)

        Button.setOnClickListener() {
            val player1 = Player1.text.toString()
            val player2 = Player2.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("NAME", player1)
            intent.putExtra("name", player2)
            startActivity(intent)

        }
    }
}