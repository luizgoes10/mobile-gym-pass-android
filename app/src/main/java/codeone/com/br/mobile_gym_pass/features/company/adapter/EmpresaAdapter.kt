package codeone.com.br.mobile_gym_pass.features.company.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.util.loadUrl
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import com.squareup.picasso.Picasso

class EmpresaAdapter(var context:Context, var empresa:List<Empresa>, val onClick:(Empresa)->Unit):
        RecyclerView.Adapter<EmpresaAdapter.EmpresaViewHolder>() {


    class EmpresaViewHolder(view:View):RecyclerView.ViewHolder(view){
        var tName:TextView
        var taddrEnd:TextView
        var ttelTel:TextView
        var tvlrMinPreco:TextView
        var tvlrMaxPreco:TextView
        var photo:ImageView
        var progressBarAdapeter:ProgressBar
        var cardView:CardView
        init{
            tName = view.findViewById<TextView>(R.id.tName)
            taddrEnd = view.findViewById<TextView>(R.id.taddrEnd)
            ttelTel = view.findViewById<TextView>(R.id.ttelTel)
            tvlrMinPreco = view.findViewById<TextView>(R.id.tvlrMinPreco)
            tvlrMaxPreco = view.findViewById<TextView>(R.id.tvlrMaxPreco)
            photo = view.findViewById<ImageView>(R.id.img)
            progressBarAdapeter = view.findViewById<ProgressBar>(R.id.pbAdapterCompany)
            cardView = view.findViewById<CardView>(R.id.card_view_company)
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

     //   holder.progressBarAdapeter.visibility = View.VISIBLE
        if(empresa.imgLogo != null){
          /*  Picasso.with(context).load(empresa.imgLogo).fit().into(holder.photo,
                    object : com.squareup.picasso.Callback{
                        override fun onSuccess() {
                            holder.progressBarAdapeter.visibility = View.GONE
                        }

                        override fun onError() {
                            holder.progressBarAdapeter.visibility = View.GONE
                        }
                    })*/
            holder.photo.loadUrl(empresa.imgLogo, holder.progressBarAdapeter)

        }else{
            holder.photo.visibility = View.INVISIBLE
            holder.progressBarAdapeter.visibility = View.GONE
        }
        holder.itemView.setOnClickListener { onClick(empresa) }
    }

    fun setList(empresas:MutableList<Empresa>){
        empresa = empresas
    }
}