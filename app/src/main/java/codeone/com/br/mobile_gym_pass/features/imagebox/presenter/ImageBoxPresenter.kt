package codeone.com.br.mobile_gym_pass.features.imagebox.presenter

import android.arch.lifecycle.LifecycleOwner
import codeone.com.br.mobile_gym_pass.commons.presenter.BasePresenter
import codeone.com.br.mobile_gym_pass.features.imagebox.domain.ImagemBox
import codeone.com.br.mobile_gym_pass.features.box.domain.Box

open class ImageBoxPresenter(val viewCallBack:ImageBoxPresenter.ViewCallBack,
                             val lifecycleOwner: LifecycleOwner = viewCallBack as LifecycleOwner):
        BasePresenter(lifecycleOwner) {
    interface ViewCallBack{

        fun setUpRecycler()
        fun setUpProgress(show:Boolean)
        fun setUpAllImages(image:List<ImagemBox>)
    }

    open fun onViewCreated(box:Box){
        viewCallBack.setUpRecycler()
        viewCallBack.setUpProgress(true)
        viewCallBack.setUpAllImages(box.imageBox)
        viewCallBack.setUpProgress(false)
    }
}