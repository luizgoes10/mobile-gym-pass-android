package codeone.com.br.mobile_gym_pass.features.imagebox.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.fragment.BaseFragment
import codeone.com.br.mobile_gym_pass.features.imagebox.presenter.ImageBoxPresenter
import codeone.com.br.mobile_gym_pass.features.imagebox.adapter.ImagemBoxAdapter
import codeone.com.br.mobile_gym_pass.features.imagebox.domain.ImagemBox
import codeone.com.br.mobile_gym_pass.features.box.domain.Box
import kotlinx.android.synthetic.main.fragment_imagem_box.*


/**
 * A simple [Fragment] subclass.
 *
 */
class ImagemBoxFragment : BaseFragment(),ImageBoxPresenter.ViewCallBack {

    private var adapter:ImagemBoxAdapter? = null
    private lateinit var box:Box
    private val presenter by lazy { ImageBoxPresenter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imagem_box, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        box = arguments!!.getParcelable<Box>("box")
        presenter.onViewCreated(box)
    }

    override fun setUpRecycler() {
        rvImageBox.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)
        rvImageBox.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
    }

    override fun setUpProgress(show: Boolean) {
        if(show){
            pbRecyclerImageBox.visibility = View.VISIBLE
        }
        else{
            pbRecyclerImageBox.visibility = View.GONE
        }
    }

    override fun setUpAllImages(imagem: List<ImagemBox>) {
        rvImageBox.visibility = View.VISIBLE
        if(adapter == null){
            adapter = ImagemBoxAdapter(context, imagem, onClickItem())
            rvImageBox.adapter = adapter
        }else{
            adapter?.setList(imagem)
            adapter?.notifyDataSetChanged()
        }
    }

    private fun onClickItem():(ImagemBox) -> Unit ={
        //faz alguma coisa
        var p = it
    }

}
