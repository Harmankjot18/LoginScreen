package com.harman.logindisplay

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.content.Intent
import android.view.View
import androidx.core.widget.doOnTextChanged


class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etPassword: EditText
    lateinit var etPhoneNumber : EditText
    lateinit var tvForgotPassword: TextView
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        etPassword = findViewById(R.id.etPassword)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)
        btnLogin = findViewById(R.id.btnLogin)

        etPassword.doOnTextChanged{text, start, before, count ->  }
        val text = etPassword

        if ((text?.length() ?:0) < 6) {
            etPassword.error = resources.getString(R.string.please_enter_password)
        }
        else{
            etPassword.error=null
        }


        btnLogin.setOnClickListener {
         etName.text.clear()
            System.out.println("Clicked")
            var name = etName.text.toString()
            var password = etPassword.text.toString()
            System.out.println("name ; $name")
            if (name.isNullOrEmpty()) {
            var name = etName.text.toString()
                etName.error = resources.getString(R.string.please_enter_name)
                etName.requestFocus()
            } else if (password.isNullOrEmpty()) {
                etPassword.error = resources.getString(R.string.please_enter_password)
                etPassword.requestFocus()
            } else {
                Toast.makeText(this.resources.getString(R.string.login_sucessfully),
                    Toast.LENGTH_LONG
                ).show()
            }
            var intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
}