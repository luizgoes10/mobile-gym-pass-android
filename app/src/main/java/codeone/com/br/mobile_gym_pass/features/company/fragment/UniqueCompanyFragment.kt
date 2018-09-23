package codeone.com.br.mobile_gym_pass.features.company.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.fragment.BaseFragment
import codeone.com.br.mobile_gym_pass.commons.util.loadUrl
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import kotlinx.android.synthetic.main.fragment_unique_company.*


class UniqueCompanyFragment : BaseFragment() {

    private lateinit var company:Empresa

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.d("fragment", "teste")
        return inflater.inflate(R.layout.fragment_unique_company, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        company = arguments?.getParcelable("empresa") as Empresa

        tvnmEmpresa.text = company.nmEmpresa

        tvnmAddr.text = company.addrEndereco

        tvnmTel.text = company.telTelefone

        imgEmpresa.loadUrl(company.imgLogo, pbFragmentEmpresa)
    }

}
