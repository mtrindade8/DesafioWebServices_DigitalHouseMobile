package com.example.desafiowebservices_digitalhousemobile.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiowebservices_digitalhousemobile.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        toolbar_registro.setNavigationOnClickListener {
            onBackPressed()
        }

        btn_salvar_registro.setOnClickListener {
            val intent = Intent(application, HqActivity::class.java)
            startActivity(intent)
        }

    }
}
