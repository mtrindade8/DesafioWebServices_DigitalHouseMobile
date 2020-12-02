package com.example.desafiowebservices_digitalhousemobile.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiowebservices_digitalhousemobile.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_registrar_login.setOnClickListener {
            val intent = Intent(application, RegisterActivity::class.java)
            startActivity(intent)
        }

        btn_logar_login.setOnClickListener {
            val intent = Intent(application, HqActivity::class.java)
            startActivity(intent)
        }
    }
}
