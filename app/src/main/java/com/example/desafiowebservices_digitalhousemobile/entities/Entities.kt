package com.example.desafiowebservices_digitalhousemobile.entities


import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

data class Hq(
    val dates: List<Date>,
    val description: String,
    val id: Int,
    val images: List<Any>,
    val issueNumber: Int,
    val pageCount: Int,
    val prices: List<Price>,
    val thumbnail: Thumbnail,
    val title: String,
) : Serializable

data class Date(
    val date: String,
    val type: String
) : Serializable {


    fun getFormattedDate(): String {

        var dataSplitada = date.substringBeforeLast("T")
        val dataOriginal = SimpleDateFormat("yyyy-MM-dd").parse(dataSplitada)
        val dataFormatada = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
        return dataFormatada.format(dataOriginal)
    }

}

data class Price(
    val price: Double,
    val type: String
) : Serializable

data class Thumbnail(
    val path: String,
    val extension: String
) : Serializable {

    fun getThumbnailPath(): String = "$path.$extension"

}





