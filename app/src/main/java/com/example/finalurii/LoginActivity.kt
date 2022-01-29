package com.example.finalurii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.finalurii.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail : EditText
    private lateinit var editTextPassword : EditText
    private lateinit var buttonLogin : Button
    private lateinit var buttonRegister : Button
    private lateinit var buttonResetPassword : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (FirebaseAuth.getInstance().currentUser!=null){
            goToProfile()
        }
        setContentView(R.layout.activity_login)

        init()
        registerListeners()
    }

    private fun init(){
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonResetPassword = findViewById(R.id.buttonResetPassword)


    }
    private fun registerListeners(){
        buttonRegister.setOnClickListener {
            startActivity(Intent(this,RegistrationActivity::class.java))
        }
        buttonResetPassword.setOnClickListener {
            startActivity(Intent(this,PasswordResetActivity::class.java))
        }
        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            if (email.isEmpty() || password.isEmpty()){

                Toast.makeText(this, "email or password is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {task->
                    if (task.isSuccessful){
                        goToProfile()

                    }else{
                        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun goToProfile(){

        startActivity(Intent(this,ResetPasswordActivity::class.java))
        finish()
    }
}