package com.example.desafiowebservices_digitalhousemobile.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.desafiowebservices_digitalhousemobile.R
import com.example.desafiowebservices_digitalhousemobile.entities.Hq
import kotlinx.android.synthetic.main.activity_detalhe_hq.*

class DetalheHqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_hq)

        val hq = intent.getSerializableExtra("hq") as Hq

        Glide.with(this).asBitmap()
            .load(hq.thumbnail.getThumbnailPath())
            .into(img_capa_detalhe_hq)

        Glide.with(this).asBitmap()
            .load(hq.thumbnail.getThumbnailPath())
            .into(img_fundo_detalhe_hq)

        txt_titulo_detalhe_hq.text = hq.title
        txt_descricao_detalhe_hq.text = hq.description
        txt_publicacao_detalhe_hq.text = hq.dates[0].date
        txt_preco_detalhe_hq.text = hq.prices[0].price.toString()
        txt_paginas_detalhe_hq.text = hq.pageCount.toString()

        toolbar_detalhe_hq.setNavigationOnClickListener {
            onBackPressed()
        }

    }
}
