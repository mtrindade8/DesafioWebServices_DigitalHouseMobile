package com.example.desafiowebservices_digitalhousemobile.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiowebservices_digitalhousemobile.entities.Hq
import com.example.desafiowebservices_digitalhousemobile.services.Repository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import java.lang.Exception

class HqViewModel(val repository: Repository) : ViewModel() {

    val hqList = MutableLiveData<ArrayList<Hq>>()

    fun getHqs() {

        try {
            viewModelScope.launch {
                val response = repository.getListaHq(
                    "1",
                    "02d2f6f10a3e8afb2368ab1949529eb2",
                    "9deccc737e48d9681dac6ab07f678b6d",
                    3,
                    64,
                )

                val results = response.get("data").asJsonObject.get("results")
                val hqObject = Gson().fromJson(
                    results,
                    object : TypeToken<List<Hq>>() {}.type
                ) as ArrayList<Hq>

                hqList.value = hqObject
            }

        }catch (e: Exception){
            Log.i("TESTE", "####################")
            throw java.lang.Exception(e)
        }
    }
}