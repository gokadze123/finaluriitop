package com.example.finalurii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.finalurii.R
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

    private lateinit var editTextEmailAddress : EditText
    private lateinit var editTextPass : EditText
    private lateinit var buttonRegi : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        init()
        registerListeners()

    }
    private fun init(){
        editTextEmailAddress = findViewById(R.id.editTextEmailAddress)
        editTextPass = findViewById(R.id.editTextPass)
        buttonRegi = findViewById(R.id.buttonRegi)

    }
    private fun registerListeners() {
        buttonRegi.setOnClickListener {

            val email = editTextEmailAddress.text.toString()
            val password = editTextPass.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "email or password is empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task->
                    if (task.isSuccessful){

                        startActivity(Intent(this,LoginActivity::class.java))
                        finish()

                    }else{

                        Toast.makeText(this, "Error 404", Toast.LENGTH_SHORT).show()
                    }



                }
        }

    }
}