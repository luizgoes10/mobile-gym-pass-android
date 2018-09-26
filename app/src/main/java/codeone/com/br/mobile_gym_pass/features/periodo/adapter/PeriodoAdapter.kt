package codeone.com.br.mobile_gym_pass.features.periodo.adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.features.periodo.domain.Periodo

class PeriodoAdapter(var context: Context?, var periodo:List<Periodo>, val onClick:(Periodo)->Unit):
        RecyclerView.Adapter<PeriodoAdapter.PeriodoViewHolder>() {


    class PeriodoViewHolder(view: View): RecyclerView.ViewHolder(view){
        var tNamePeriodo: TextView
        var tValor: TextView
        var cardView: CardView
        init{
            tNamePeriodo = view.findViewById<TextView>(R.id.tNamePeriodo)
            tValor = view.findViewById<TextView>(R.id.tValor)
            cardView = view.findViewById<CardView>(R.id.card_view_periodo)
        }
    }

    override fun getItemCount(): Int {
        return periodo.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeriodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_periodo,parent,false)
        return PeriodoViewHolder(view)
    }
    override fun onBindViewHolder(holder: PeriodoViewHolder, position: Int) {
        val context = holder.itemView.context
        val periodo = periodo[position]
        holder.tNamePeriodo.text = periodo.nmDescricao

        holder.tValor.text = periodo.vlrPeriodo.toString()

        holder.itemView.setOnClickListener { onClick(periodo) }
    }

    fun setList(periodos:MutableList<Periodo>){
        periodo = periodos
    }
}