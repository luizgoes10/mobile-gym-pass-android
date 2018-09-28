package codeone.com.br.mobile_gym_pass.features.box.presenter

import android.arch.lifecycle.LifecycleOwner
import codeone.com.br.mobile_gym_pass.commons.presenter.BasePresenter
import codeone.com.br.mobile_gym_pass.features.box.domain.Box

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