package codeone.com.br.mobile_gym_pass.features.company.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.fragment.BaseFragment
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import org.jetbrains.anko.support.v4.find



/**
 * A simple [Fragment] subclass.
 *
 */
class CompanyFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val inflater = inflater.inflate(R.layout.fragment_company, container, false)
        return inflater
    }
}
