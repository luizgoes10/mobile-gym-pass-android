package codeone.com.br.mobile_gym_pass.features.periodo.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.fragment.BaseFragment
import codeone.com.br.mobile_gym_pass.features.box.domain.Box
import codeone.com.br.mobile_gym_pass.features.periodo.adapter.PeriodoAdapter
import codeone.com.br.mobile_gym_pass.features.periodo.domain.Periodo
import codeone.com.br.mobile_gym_pass.features.periodo.presenter.PeriodoPresenter
import kotlinx.android.synthetic.main.fragment_boxes.*
import kotlinx.android.synthetic.main.fragment_periodo.*


/**
 * A simple [Fragment] subclass.
 *
 */
class PeriodoFragment : BaseFragment(), PeriodoPresenter.ViewCallBack {
    private var adapter:PeriodoAdapter? = null
    private lateinit var box:Box
    private val presenter by lazy { PeriodoPresenter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_periodo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        box = arguments?.getParcelable("box") as Box
        presenter.onViewCreated(box)
    }

    override fun setUpRecycler() {
        rvPeriodo.layoutManager = LinearLayoutManager(context)
        rvPeriodo.itemAnimator = DefaultItemAnimator()
    }

    override fun setUpProgress(show: Boolean) {
        if(show){
            pbRecyclerPeriodo.visibility = View.VISIBLE
        }
        else{
            pbRecyclerPeriodo.visibility = View.GONE
        }
    }

    override fun setUpAllPeriodo(periodo: List<Periodo>) {
        rvPeriodo.visibility = View.VISIBLE
        if(adapter == null){
            adapter = PeriodoAdapter(context, periodo, onClickItem())
            rvPeriodo.adapter = adapter
        }else{
            adapter?.setList(periodo)
            adapter?.notifyDataSetChanged()
        }
    }

    private fun onClickItem():(Periodo) -> Unit ={
        //faz alguma coisa
        var p = it
    }
}
