package com.example.desafiowebservices_digitalhousemobile.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiowebservices_digitalhousemobile.adapters.HqAdapter
import com.example.desafiowebservices_digitalhousemobile.contract.OnClickItemListener
import com.example.desafiowebservices_digitalhousemobile.databinding.ActivityHqBinding
import com.example.desafiowebservices_digitalhousemobile.models.HqViewModel
import com.example.desafiowebservices_digitalhousemobile.services.repository


class HqActivity : AppCompatActivity(), OnClickItemListener {

    private lateinit var binding: ActivityHqBinding

    val viewModel by viewModels<HqViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HqViewModel(repository) as T
            }
        }
    }

    private lateinit var adapter : HqAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHqBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = HqAdapter(this)
        binding.rcvContainerHq.adapter = adapter

        viewModel.hqList.observe(this){
            adapter.addList(it)
        }

        viewModel.getHqs()

    }

    override fun OnClickItem(position: Int) {
        val hq = viewModel.hqList.value?.get(position)

        val intent = Intent(this, DetalheHqActivity::class.java)
        intent.putExtra("hq", hq)
        startActivity(intent)
    }
}