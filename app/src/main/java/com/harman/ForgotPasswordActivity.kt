package com.harman

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var btnForgotPassword :Button
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
   etEmail=findViewById(R.string.etEmail)
        btnForgotPassword=findViewById(R.string.btnForget)

        btnForgotPassword.setOnClickListener{
            if(etEmail.text.toString().isNullOrEmpty()){
                etEmail.requestFocus()
                Toast.makeText(this,resources.getText(R.string.enter_email),Toast.LENGTH_SHORT).show()
            }
            else{
                var intent =Intent(this,OTPactivity::class.java)
                intent.putExtra("emailid",etEmail.text.toString())
                startActivity(intent)
            }
        }
    }
}