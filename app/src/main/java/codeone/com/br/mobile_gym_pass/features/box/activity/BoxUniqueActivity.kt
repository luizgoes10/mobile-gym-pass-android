package codeone.com.br.mobile_gym_pass.features.box.activity

import android.os.Bundle
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.activity.BaseActivity
import codeone.com.br.mobile_gym_pass.commons.util.addFragment
import codeone.com.br.mobile_gym_pass.commons.util.setupToolbar
import codeone.com.br.mobile_gym_pass.features.box.domain.Box
import codeone.com.br.mobile_gym_pass.features.box.presenter.BoxUniquePresenter
import codeone.com.br.mobile_gym_pass.features.periodo.fragment.PeriodoFragment

class BoxUniqueActivity : BaseActivity(),BoxUniquePresenter.ViewCallBack {

    private lateinit var box: Box
    private val presenter by lazy { BoxUniquePresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_box)
        box = intent.getParcelableExtra<Box>("box")
        setupToolbar(R.id.myToolbar, box.nmBox, true)
        presenter.onViewCreated()
    }

    override fun setUpFragments() {
        val fragPeriodo = PeriodoFragment()
        addFragment(R.id.framePeriodo, fragPeriodo)
    }
}
