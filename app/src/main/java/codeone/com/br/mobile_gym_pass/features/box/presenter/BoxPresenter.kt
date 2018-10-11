package codeone.com.br.mobile_gym_pass.features.box.presenter

import androidx.lifecycle.LifecycleOwner
import codeone.com.br.mobile_gym_pass.commons.presenter.BasePresenter

open class BoxPresenter(val viewCallBack: ViewCallBack,
                        val lifecycleOwner: LifecycleOwner = viewCallBack as LifecycleOwner):
        BasePresenter(lifecycleOwner) {
    interface ViewCallBack{

        fun setUpAttributes()
    }

    open fun onViewCreated(){

        viewCallBack.setUpAttributes()
    }
}