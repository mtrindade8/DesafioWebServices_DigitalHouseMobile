package com.example.desafiowebservices_digitalhousemobile.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiowebservices_digitalhousemobile.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrarLogin.setOnClickListener {
            val intent = Intent(application, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogarLogin.setOnClickListener {
            val intent = Intent(application, HqActivity::class.java)
            startActivity(intent)
        }
    }
}
