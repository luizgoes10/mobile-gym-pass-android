package codeone.com.br.mobile_gym_pass.features.company.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.fragment.BaseFragment


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
