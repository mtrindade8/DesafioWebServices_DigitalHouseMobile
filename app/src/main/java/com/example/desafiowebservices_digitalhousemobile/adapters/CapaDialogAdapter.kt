package com.example.desafiowebservices_digitalhousemobile.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.desafiowebservices_digitalhousemobile.R

class CapaDialogAdapter: DialogFragment() {

    private var imagemPath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.DialogStyle);
        arguments?.let {
            imagemPath = it.getString(ARG_IMAGEM)
        }
    }

    companion object {
        const val TAG = "capaDialog"
        private const val ARG_IMAGEM = "argImagem"

        fun newInstance(imagemPath: String) = CapaDialogAdapter().apply {
            arguments = Bundle().apply {
                putString(ARG_IMAGEM, imagemPath)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.dialog_fragment_capa, container, false)
        dialog?.window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawableResource(R.color.azulMarvel)

        var imgCapa   = rootView.findViewById<ImageView>(R.id.img_hq_dialog_capa)
        var btnFechar = rootView.findViewById<ImageButton>(R.id.btn_fechar_dialog_capa)

        Glide.with(this).asBitmap()
            .load(imagemPath?.replace("http", "https"))
            .into(imgCapa)

        btnFechar.setOnClickListener{
            dismiss()
        }

        return rootView
    }

}
