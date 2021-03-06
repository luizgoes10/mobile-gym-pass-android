package codeone.com.br.mobile_gym_pass.features.box.adapter

import android.content.Context
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.util.loadUrl
import codeone.com.br.mobile_gym_pass.features.box.domain.Box

class BoxAdapter(var context: Context?, var box:List<Box>?, val onClick:(Box)->Unit):
        androidx.recyclerview.widget.RecyclerView.Adapter<BoxAdapter.BoxViewHolder>() {


    class BoxViewHolder(view: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view){
        var tName: TextView
        var tVer: TextView
        var photo: ImageView
        var imgVer:ImageView
        var progressBarAdapeterBox: ProgressBar
        var cardView: androidx.cardview.widget.CardView
        init{
            tName = view.findViewById<TextView>(R.id.tNameBox)
            tVer = view.findViewById<TextView>(R.id.tVer)
            photo = view.findViewById<ImageView>(R.id.imgBox)
            imgVer = view.findViewById<ImageView>(R.id.imgVer)
            progressBarAdapeterBox = view.findViewById<ProgressBar>(R.id.pbAdapterBox)
            cardView = view.findViewById<androidx.cardview.widget.CardView>(R.id.card_view_box)
        }
    }

    override fun getItemCount(): Int {
        return box!!.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoxViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_box,parent,false)
        return BoxViewHolder(view)
    }
    override fun onBindViewHolder(holder: BoxViewHolder, position: Int) {
        val context = holder.itemView.context
        val box = box!![position]
        holder.tName.text = box.nmBox

        holder.tVer.text = "Ver valores"

        if(box.imgFoto != null){

            holder.photo.loadUrl(box.imgFoto, holder.progressBarAdapeterBox)

        }else{
            holder.photo.visibility = View.INVISIBLE
            holder.progressBarAdapeterBox.visibility = View.GONE
        }
        holder.itemView.setOnClickListener { onClick(box) }
    }

    fun setList(boxes:List<Box>){
        box = boxes
    }
}