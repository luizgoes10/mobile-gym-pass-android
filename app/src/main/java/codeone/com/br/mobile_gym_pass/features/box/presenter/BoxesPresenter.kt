package codeone.com.br.mobile_gym_pass.features.box.presenter

import androidx.lifecycle.LifecycleOwner
import codeone.com.br.mobile_gym_pass.commons.presenter.BasePresenter
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import codeone.com.br.mobile_gym_pass.features.box.domain.Box

open class BoxesPresenter(val viewCallBack: ViewCallBack,
                          val lifecycleOwner: LifecycleOwner = viewCallBack as LifecycleOwner):
        BasePresenter(lifecycleOwner) {
    interface ViewCallBack{

        fun setUpRecycler()
        fun setUpProgress(show:Boolean)
        fun setUpAllBox(box:List<Box>)
    }
    open fun onViewCreated(empresa: Empresa){

        viewCallBack.setUpRecycler()

        viewCallBack.setUpProgress(true)

        viewCallBack.setUpAllBox(empresa.box)

        viewCallBack.setUpProgress(false)

    }
}