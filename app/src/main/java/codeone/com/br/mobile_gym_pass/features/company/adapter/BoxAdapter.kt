package codeone.com.br.mobile_gym_pass.features.company.adapter

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
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import codeone.com.br.mobile_gym_pass.features.regions.domain.Box

class BoxAdapter(var context: Context, var box:List<Box>, val onClick:(Box)->Unit):
        RecyclerView.Adapter<BoxAdapter.BoxViewHolder>() {


    class BoxViewHolder(view: View): RecyclerView.ViewHolder(view){
        var tName: TextView

        var photo: ImageView
        var progressBarAdapeterBox: ProgressBar
        var cardView: CardView
        init{
            tName = view.findViewById<TextView>(R.id.tNameBox)
            photo = view.findViewById<ImageView>(R.id.img)
            progressBarAdapeterBox = view.findViewById<ProgressBar>(R.id.pbAdapterBox)
            cardView = view.findViewById<CardView>(R.id.card_view_box)
        }
    }

    override fun getItemCount(): Int {
        return box.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoxViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_box,parent,false)
        return BoxViewHolder(view)
    }
    override fun onBindViewHolder(holder: BoxViewHolder, position: Int) {
        val context = holder.itemView.context
        val box = box[position]
        holder.tName.text = box.nmBox

        if(box.imgFoto != null){

            holder.photo.loadUrl(box.imgFoto, holder.progressBarAdapeterBox)

        }else{
            holder.photo.visibility = View.INVISIBLE
            holder.progressBarAdapeterBox.visibility = View.GONE
        }
        holder.itemView.setOnClickListener { onClick(box) }
    }

    fun setList(boxes:MutableList<Box>){
        box = boxes
    }
}