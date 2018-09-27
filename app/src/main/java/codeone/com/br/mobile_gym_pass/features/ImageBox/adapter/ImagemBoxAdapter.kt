package codeone.com.br.mobile_gym_pass.features.ImageBox.adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.util.loadUrl
import codeone.com.br.mobile_gym_pass.features.ImageBox.domain.ImagemBox
import codeone.com.br.mobile_gym_pass.features.box.adapter.BoxAdapter
import codeone.com.br.mobile_gym_pass.features.box.domain.Box

open class ImagemBoxAdapter(var context: Context?, var imagemBox:List<ImagemBox>, val onClick:(ImagemBox)->Unit):
        RecyclerView.Adapter<ImagemBoxAdapter.ImagemBoxViewHolder>() {


    class ImagemBoxViewHolder(view: View): RecyclerView.ViewHolder(view){
        var photo: ImageView
        var progressBarAdapeterBox: ProgressBar
        var cardView: CardView
        init{
            photo = view.findViewById<ImageView>(R.id.imgAdapterImagemBox)
            progressBarAdapeterBox = view.findViewById<ProgressBar>(R.id.pbAdapterImagemBox)
            cardView = view.findViewById<CardView>(R.id.card_view_imagem_box)
        }
    }

    override fun getItemCount(): Int {
        return imagemBox.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagemBoxViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_imagem_box,parent,false)
        return ImagemBoxViewHolder(view)
    }
    override fun onBindViewHolder(holder: ImagemBoxViewHolder, position: Int) {
        val context = holder.itemView.context
        val imagemBox = imagemBox[position]

        if(imagemBox.nmDescricao != null){

            holder.photo.loadUrl(imagemBox.nmDescricao, holder.progressBarAdapeterBox)

        }else{
            holder.photo.visibility = View.INVISIBLE
            holder.progressBarAdapeterBox.visibility = View.GONE
        }
        holder.itemView.setOnClickListener { onClick(imagemBox) }
    }

    fun setList(imagemBoxes:MutableList<ImagemBox>){
        imagemBox = imagemBoxes
    }
}