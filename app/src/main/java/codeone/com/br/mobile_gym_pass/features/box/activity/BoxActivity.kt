package codeone.com.br.mobile_gym_pass.features.box.activity

import android.os.Bundle
import android.widget.ImageView
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.activity.BaseActivity
import codeone.com.br.mobile_gym_pass.commons.util.addFragment
import codeone.com.br.mobile_gym_pass.commons.util.loadUrl
import codeone.com.br.mobile_gym_pass.commons.util.setupToolbar
import codeone.com.br.mobile_gym_pass.features.imagebox.fragment.ImagemBoxFragment
import codeone.com.br.mobile_gym_pass.features.box.domain.Box
import codeone.com.br.mobile_gym_pass.features.box.fragment.BoxFragment
import codeone.com.br.mobile_gym_pass.features.box.presenter.BoxActivityPresenter
import codeone.com.br.mobile_gym_pass.features.imagebox.fragment.NotImgFragment
import codeone.com.br.mobile_gym_pass.features.periodo.fragment.PeriodoFragment
import kotlinx.android.synthetic.main.activity_box.*

class BoxActivity : BaseActivity(),BoxActivityPresenter.ViewCallBack {

    private lateinit var box: Box
    private val presenter by lazy { BoxActivityPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_box)
        box = intent.getParcelableExtra<Box>("box")
        setupToolbar(R.id.toolbar, box.nmBox, true)

        presenter.onViewCreated()
    }

    override fun setUpFragments() {

        expandedImage.loadUrl(box.imgFoto)
        val fragPeriodo = PeriodoFragment()
        val fragBox = BoxFragment()
        addFragment(R.id.framePeriodo, fragPeriodo)
       addFragment(R.id.frameBox, fragBox)
    if(!box.imageBox.isEmpty()){
            val fragImageBox = ImagemBoxFragment()
            addFragment(R.id.frameImageBox, fragImageBox)
        }else{

            val fragSemFoto = NotImgFragment()
            addFragment(R.id.frameImageBox, fragSemFoto)
        }
    }
}
