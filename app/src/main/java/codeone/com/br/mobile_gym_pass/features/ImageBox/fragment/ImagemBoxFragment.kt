package codeone.com.br.mobile_gym_pass.features.ImageBox.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.fragment.BaseFragment


/**
 * A simple [Fragment] subclass.
 *
 */
class ImagemBoxFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imagem_box, container, false)
    }


}
