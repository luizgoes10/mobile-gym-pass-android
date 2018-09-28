package codeone.com.br.mobile_gym_pass.features.box.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.activity.BaseActivity
import codeone.com.br.mobile_gym_pass.commons.fragment.BaseFragment
import codeone.com.br.mobile_gym_pass.commons.util.loadUrl
import codeone.com.br.mobile_gym_pass.features.box.domain.Box
import codeone.com.br.mobile_gym_pass.features.box.presenter.BoxPresenter
import kotlinx.android.synthetic.main.fragment_box.*


/**
 * A simple [Fragment] subclass.
 *
 */
class BoxFragment : BaseFragment(),BoxPresenter.ViewCallBack {

    private val presenter by lazy { BoxPresenter(this) }
    private lateinit var box:Box

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_box, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        box = arguments!!.getParcelable<Box>("box")
        presenter.onViewCreated()
    }

    override fun setUpAttributes() {
        imgFoto.loadUrl(box.imgFoto, pbFragmentBox)
        tNmBox.text = box.nmBox
        tTxtAmbiente.text = box.txtAmbiente
       // tTxtInfo.text = box.txtInfo
        tNmInfoImportante.text = box.nmInfoImportante
    }

}
