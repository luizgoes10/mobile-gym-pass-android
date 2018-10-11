package codeone.com.br.mobile_gym_pass.features.company.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.util.loadUrl
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa

class EmpresaAdapter(var context:Context, var empresa:List<Empresa>, val onClick:(Empresa)->Unit):
        androidx.recyclerview.widget.RecyclerView.Adapter<EmpresaAdapter.EmpresaViewHolder>() {


    class EmpresaViewHolder(view:View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view){
        var tName:TextView
        var taddrEnd:TextView
        var ttelTel:TextView
        var tvlrMinPreco:TextView
        var tvlrMaxPreco:TextView
        var photo:ImageView
        var progressBarAdapeter:ProgressBar
        var cardView: androidx.cardview.widget.CardView
        init{
            tName = view.findViewById<TextView>(R.id.tName)
            taddrEnd = view.findViewById<TextView>(R.id.taddrEnd)
            ttelTel = view.findViewById<TextView>(R.id.ttelTel)
            tvlrMinPreco = view.findViewById<TextView>(R.id.tvlrMinPreco)
            tvlrMaxPreco = view.findViewById<TextView>(R.id.tvlrMaxPreco)
            photo = view.findViewById<ImageView>(R.id.img)
            progressBarAdapeter = view.findViewById<ProgressBar>(R.id.pbAdapterCompany)
            cardView = view.findViewById<androidx.cardview.widget.CardView>(R.id.card_view_company)
        }
    }

    override fun getItemCount(): Int {
        return empresa.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpresaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_empresa,parent,false)
        return EmpresaViewHolder(view)
    }
    override fun onBindViewHolder(holder: EmpresaViewHolder, position: Int) {
        val context = holder.itemView.context
        val empresa = empresa[position]
        holder.tName.text = empresa.nmEmpresa
        holder.taddrEnd.text = empresa.addrEndereco
        holder.ttelTel.text = empresa.telTelefone
        holder.tvlrMinPreco.text = empresa.vlrMinPreco.toString()
        holder.tvlrMaxPreco.text = empresa.vlrMaxPreco.toString()

        if(empresa.imgLogo != null){

            holder.photo.loadUrl(empresa.imgLogo, holder.progressBarAdapeter)

        }else{
            holder.photo.visibility = View.INVISIBLE
            holder.progressBarAdapeter.visibility = View.GONE
        }
        holder.itemView.setOnClickListener { onClick(empresa) }
    }

    fun setList(empresas:List<Empresa>){
        empresa = empresas
    }
}