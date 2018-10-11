package codeone.com.br.mobile_gym_pass.features.imagebox.adapter

import android.content.Context
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.util.loadUrl
import codeone.com.br.mobile_gym_pass.features.imagebox.domain.ImagemBox

open class ImagemBoxAdapter(var context: Context?, var imagemBox:List<ImagemBox>, val onClick:(ImagemBox)->Unit):
        androidx.recyclerview.widget.RecyclerView.Adapter<ImagemBoxAdapter.ImagemBoxViewHolder>() {


    class ImagemBoxViewHolder(view: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view){
        var photo: ImageView
        var progressBarAdapeterBox: ProgressBar
        var cardView: androidx.cardview.widget.CardView
        init{
            photo = view.findViewById<ImageView>(R.id.imgAdapterImagemBox)
            progressBarAdapeterBox = view.findViewById<ProgressBar>(R.id.pbAdapterImagemBox)
            cardView = view.findViewById<androidx.cardview.widget.CardView>(R.id.card_view_imagem_box)
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

    fun setList(imagemBoxes:List<ImagemBox>){
        imagemBox = imagemBoxes
    }
}