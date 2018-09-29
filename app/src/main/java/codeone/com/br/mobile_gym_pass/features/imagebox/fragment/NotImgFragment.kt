package codeone.com.br.mobile_gym_pass.features.imagebox.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.fragment.BaseFragment
import codeone.com.br.mobile_gym_pass.commons.util.loadUrl
import kotlinx.android.synthetic.main.fragment_not_img.*


/**
 * A simple [Fragment] subclass.
 *
 */
class NotImgFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_not_img, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgSemFoto.loadUrl(getString(R.string.sem_foto),pbSemFoto)
    }
}
