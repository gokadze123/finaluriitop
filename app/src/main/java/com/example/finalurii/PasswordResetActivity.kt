package com.example.finalurii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.finalurii.R
import com.google.firebase.auth.FirebaseAuth

class PasswordResetActivity : AppCompatActivity() {

    private lateinit var editTextTextEmailAddress : EditText
    private lateinit var buttonSend : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset)

        init()
        registerListeners()
    }

    private fun init(){
        buttonSend = findViewById(R.id.buttonSend)
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress)

    }
    private fun  registerListeners(){
        buttonSend .setOnClickListener {
            val email = editTextTextEmailAddress.text.toString()

            if (email.isEmpty()){

                Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        Toast.makeText(this, "check your mail", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}