package codeone.com.br.mobile_gym_pass.features.imagebox.fragment


import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.fragment.BaseFragment
import codeone.com.br.mobile_gym_pass.features.box.domain.Box
import kotlinx.android.synthetic.main.fragment_img_box_carousel.*
import android.widget.ImageView
import codeone.com.br.mobile_gym_pass.commons.util.loadUrl
import com.synnapps.carouselview.ImageListener


/**
 * A simple [Fragment] subclass.
 *
 */
class ImgBoxCarouselFragment : BaseFragment() {

    private lateinit var box:Box
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_img_box_carousel, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        box = arguments!!.getParcelable<Box>("box")
        carousel.pageCount = box.imageBox.size
        carousel.setImageListener{position, imageView ->
            imgBoxCarousel.loadUrl(box.imageBox[0].nmDescricao)
        }
    }
}
