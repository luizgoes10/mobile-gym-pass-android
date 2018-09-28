package codeone.com.br.mobile_gym_pass.features.box.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.fragment.BaseFragment
import codeone.com.br.mobile_gym_pass.features.box.activity.BoxActivity
import codeone.com.br.mobile_gym_pass.features.box.adapter.BoxAdapter
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import codeone.com.br.mobile_gym_pass.features.box.presenter.BoxesPresenter
import codeone.com.br.mobile_gym_pass.features.box.domain.Box
import kotlinx.android.synthetic.main.fragment_boxes.*
import org.jetbrains.anko.startActivity


/**
 * A simple [Fragment] subclass.
 *
 */
class BoxesFragment : BaseFragment(), BoxesPresenter.ViewCallBack {

    private var adapter: BoxAdapter? = null
    private lateinit var empresa: Empresa
    private val presenter by lazy { BoxesPresenter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_boxes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        empresa = arguments?.getParcelable("empresa") as Empresa
        presenter.onViewCreated(empresa)
    }

    override fun setUpRecycler() {
        rvBox.layoutManager = LinearLayoutManager(context)
        rvBox.itemAnimator = DefaultItemAnimator()
    }

    override fun setUpProgress(show:Boolean) {
        if(show){
            pbRecyclerBox.visibility = View.VISIBLE
        }
        else{
            pbRecyclerBox.visibility = View.GONE
        }
    }

    override fun setUpAllBox(box: MutableList<Box>) {
        rvBox.visibility = View.VISIBLE
        if(adapter == null){
            adapter = BoxAdapter(context, box, onClickItem())
            rvBox.adapter = adapter
        }else{
            adapter?.setList(box)
            adapter?.notifyDataSetChanged()
        }
    }

    private fun onClickItem():(Box) -> Unit ={
        activity?.startActivity<BoxActivity>("box" to it)
    }

}
