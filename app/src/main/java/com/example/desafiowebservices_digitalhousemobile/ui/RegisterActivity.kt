package com.example.desafiowebservices_digitalhousemobile.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiowebservices_digitalhousemobile.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarRegistro.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.btnSalvarRegistro.setOnClickListener {
            val intent = Intent(application, HqActivity::class.java)
            startActivity(intent)
        }

    }
}
