package com.example.desafiowebservices_digitalhousemobile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservices_digitalhousemobile.R
import com.example.desafiowebservices_digitalhousemobile.entities.Hq
import com.bumptech.glide.Glide
import com.example.desafiowebservices_digitalhousemobile.contract.OnClickItemListener
import kotlinx.android.synthetic.main.item_recyclerview_hq.view.*

class HqAdapter(val listener : OnClickItemListener) : RecyclerView.Adapter<HqAdapter.HqViewHolder>() {

    var hqList: ArrayList<Hq> =  ArrayList<Hq>()

    inner class HqViewHolder(val view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        val imgCapa : ImageView = view.img_capa_hq
        val txtEdicao : TextView = view.txt_edicao_hq

        fun bindView(hq: Hq) {
            txtEdicao.text = ("#${hq.issueNumber.toString()}")
            Glide.with(view.context).asBitmap()
                .load(hq.thumbnail.getThumbnailPath())
                .into(imgCapa)
        }

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION)
                listener.OnClickItem(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HqViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_hq, parent, false)
        return HqViewHolder(view)
    }

    override fun getItemCount() = hqList.size

    override fun onBindViewHolder(holder: HqViewHolder, position: Int) {
        val hq = hqList[position]
        holder.bindView(hq)
    }

    fun addList(lista: ArrayList<Hq>){
        hqList.addAll(lista)
        notifyDataSetChanged()
    }

}