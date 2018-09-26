package codeone.com.br.mobile_gym_pass.features.company.presenter

import android.arch.lifecycle.LifecycleOwner
import codeone.com.br.mobile_gym_pass.commons.presenter.BasePresenter
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import codeone.com.br.mobile_gym_pass.features.regions.domain.Box

open class BoxPresenter(val viewCallBack:BoxPresenter.ViewCallBack,
                        val lifecycleOwner: LifecycleOwner = viewCallBack as LifecycleOwner):
        BasePresenter(lifecycleOwner) {
    interface ViewCallBack{

        fun setUpRecycler()
        fun setUpProgress(show:Boolean)
        fun setUpAllBox(box:MutableList<Box>)
    }
    open fun onViewCreated(empresa: Empresa){

        viewCallBack.setUpRecycler()

        viewCallBack.setUpProgress(true)

        viewCallBack.setUpAllBox(empresa.box)

        viewCallBack.setUpProgress(false)

    }
}