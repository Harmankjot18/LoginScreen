package com.harman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.view.View
import android.content.Intent
import androidx.core.widget.doOnTextChanged
import android.widget.Toast
import android.graphics.ColorSpace

class MainActivity : AppCompatActivity() {
    lateinit var  etName:EditText
    lateinit var etPassword:EditText
    lateinit var etPhoneNumber:EditText
    lateinit var tvForgotPassword: TextView
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        etPassword = findViewById(R.id.etPassword)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        btnLogin = findViewById(R.id.btnLogin)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)
        tvForgotPassword.setOnClickListener {
            var intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        etPassword.doOnTextChanged{text, start, before, count ->

        if ((text?.length ?:0) < 6) {
            etPassword.error = resources.getString(R.string.please_enter_password)
        }
            else{
                etPassword.error==null
        }

            etPhoneNumber.doOnTextChanged { text, start, before, count ->
                if((text?.length ?:0) <10){
                    etPhoneNumber.error = resources.getString(R.string.enter_phone)
                }
            }

        }
        btnLogin.setOnClickListener {
            System.out.println("Clicked")
            var name = etName.text.toString()
            var password = etPassword.text.toString()
            var phone = etPhoneNumber.text.toString()
            System.out.println("name ; $name")
            if (name.isNullOrEmpty()) {
            var name = etName.text.toString()
                etName.error = resources.getString(R.string.please_enter_name)
                etName.requestFocus()
            } else if (password.isNullOrEmpty()) {
                etPassword.error = resources.getString(R.string.please_enter_password)
                etPassword.requestFocus()
            }
            else if(password.length<6){
                etPassword.error=resources.getString(R.string.please_enter_password)
                etPassword.requestFocus()
            }
            else if (phone.isNullOrEmpty()){
                etPhoneNumber.error=resources.getString(R.string.please_enter_phoneNumber)
                etPhoneNumber.requestFocus()
            }
            else {
                Toast.makeText(
                    this, resources.getString(R.string.login_sucessfully),
                    Toast.LENGTH_LONG
                ).show()
                var intent = Intent(this, ForgotPasswordActivity::class.java)
                startActivity(intent)
    }
    }
}
}