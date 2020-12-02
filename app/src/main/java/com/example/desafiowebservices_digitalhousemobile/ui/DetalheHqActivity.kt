package com.example.desafiowebservices_digitalhousemobile.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.desafiowebservices_digitalhousemobile.adapters.CapaDialogAdapter
import com.example.desafiowebservices_digitalhousemobile.databinding.ActivityDetalheHqBinding
import com.example.desafiowebservices_digitalhousemobile.entities.Hq


class DetalheHqActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalheHqBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheHqBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hq = intent.getSerializableExtra("hq") as Hq

        Glide.with(this).asBitmap()
            .load(hq.thumbnail.getThumbnailPath().replace("http", "https"))
            .into(binding.imgCapaDetalheHq)

        Glide.with(this).asBitmap()
            .load(hq.thumbnail.getThumbnailPath().replace("http", "https"))
            .into(binding.imgFundoDetalheHq)

        binding.txtTituloDetalheHq.text = hq.title
        binding.txtDescricaoDetalheHq.text = hq.description
        binding.txtPublicacaoDetalheHq.text = hq.dates[0].getFormattedDate()
        binding.txtPrecoDetalheHq.text = hq.prices[0].price.toString()
        binding.txtPaginasDetalheHq.text = hq.pageCount.toString()

        binding.toolbarDetalheHq.setNavigationOnClickListener {
            onBackPressed()
        }

        var capaDetalheDialog = CapaDialogAdapter.newInstance(hq.thumbnail.getThumbnailPath())

        binding.imgCapaDetalheHq.setOnClickListener {
            capaDetalheDialog.show(supportFragmentManager, "capaDialog")
        }

    }
}
