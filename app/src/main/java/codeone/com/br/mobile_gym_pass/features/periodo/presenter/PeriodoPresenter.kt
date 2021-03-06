package codeone.com.br.mobile_gym_pass.features.periodo.presenter

import androidx.lifecycle.LifecycleOwner
import codeone.com.br.mobile_gym_pass.commons.presenter.BasePresenter
import codeone.com.br.mobile_gym_pass.features.box.domain.Box
import codeone.com.br.mobile_gym_pass.features.periodo.domain.Periodo

open class PeriodoPresenter(val viewCallBack: PeriodoPresenter.ViewCallBack,
                            val lifecycleOwner: LifecycleOwner = viewCallBack as LifecycleOwner):
        BasePresenter(lifecycleOwner)  {
    interface ViewCallBack{

        fun setUpRecycler()
        fun setUpProgress(show:Boolean)
        fun setUpAllPeriodo(periodo:List<Periodo>)

    }

    open fun onViewCreated(box: Box){

        viewCallBack.setUpRecycler()

        viewCallBack.setUpProgress(true)

        viewCallBack.setUpAllPeriodo(box.periodo)

        viewCallBack.setUpProgress(false)

    }
}