package codeone.com.br.mobile_gym_pass.features.company.activity

import android.os.Bundle
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.activity.BaseActivity
import codeone.com.br.mobile_gym_pass.commons.util.setupToolbar
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import codeone.com.br.mobile_gym_pass.features.company.fragment.CompanyFragment
import codeone.com.br.mobile_gym_pass.features.company.fragment.UniqueCompanyFragment

class CompanyActivity : BaseActivity() {

    private lateinit var company:Empresa

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        company = intent.getParcelableExtra<Empresa>("empresa")

        setupToolbar(R.id.myToolbar, company.nmEmpresa, upNavigation = true)

        if(savedInstanceState == null){

            val transaction = supportFragmentManager.beginTransaction()

            val frag = UniqueCompanyFragment()

            frag.arguments = intent.extras

            transaction.replace(R.id.frameEmpresa, frag).commit()
        }


    }
}
