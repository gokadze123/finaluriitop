package com.example.finalurii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {
    private lateinit var editTextPasswordChange : EditText
    private lateinit var buttonPassswordChange : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)

        init()
        changeListeners()
    }
    private fun init(){

        editTextPasswordChange = findViewById(R.id.editTextPasswordChange)
        buttonPassswordChange = findViewById(R.id.buttonPassswordChange)


    }
    private fun changeListeners(){
        buttonPassswordChange.setOnClickListener {
            val newpassword = editTextPasswordChange.text.toString()
            if (newpassword.isEmpty()){
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener


            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newpassword)?.addOnCompleteListener { task->
                if (task.isSuccessful){
                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }}

