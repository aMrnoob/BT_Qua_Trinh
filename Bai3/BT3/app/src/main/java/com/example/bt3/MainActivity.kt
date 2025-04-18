package com.example.bt3

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val imageButton: ImageButton = findViewById(R.id.imageButton3)
        imageButton.setOnClickListener {
            setContentView(R.layout.activity_main)
        }

        val btnRegister: Button = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener {
            setContentView(R.layout.activity_sign_up)
        }
    }
}
