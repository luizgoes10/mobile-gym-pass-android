package codeone.com.br.mobile_gym_pass.features.company.activity

import android.os.Bundle
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.activity.BaseActivity
import codeone.com.br.mobile_gym_pass.commons.fragment.MapsFragment
import codeone.com.br.mobile_gym_pass.commons.util.addFragment
import codeone.com.br.mobile_gym_pass.commons.util.setupToolbar
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import codeone.com.br.mobile_gym_pass.features.box.fragment.BoxesFragment
import codeone.com.br.mobile_gym_pass.features.company.fragment.UniqueCompanyFragment
import codeone.com.br.mobile_gym_pass.features.company.presenter.CompanyPresenter

class CompanyActivity : BaseActivity(), CompanyPresenter.ViewCallBack {

    private lateinit var company:Empresa

    private val presenter by lazy { CompanyPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        company = intent.getParcelableExtra<Empresa>("empresa")

        setupToolbar(R.id.myToolbar, company.nmEmpresa, upNavigation = true)

        presenter.onViewCreated(savedInstanceState, company)

    }


    override fun setUpFragments(bundle: Bundle?) {

        if(bundle == null){
            val frag = UniqueCompanyFragment()
            val fragBox = BoxesFragment()
            fragBox.arguments = intent.extras
            frag.arguments = intent.extras
            addFragment(R.id.frameEmpresa, frag)
            addFragment(R.id.frameBoxes, fragBox)
        }

    }

    override fun setUpMapsFragment(bundle: Bundle) {
        val fragMaps = MapsFragment()
        fragMaps.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.frameMaps, fragMaps).commit()
    }

}
