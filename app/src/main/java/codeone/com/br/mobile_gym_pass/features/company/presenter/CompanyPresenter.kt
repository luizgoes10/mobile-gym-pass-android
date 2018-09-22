package codeone.com.br.mobile_gym_pass.features.company.presenter

import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import codeone.com.br.mobile_gym_pass.commons.presenter.BasePresenter
import codeone.com.br.mobile_gym_pass.features.regions.presenter.MainPresenter

open class CompanyPresenter(val viewCallback: CompanyPresenter.ViewCallBack,
                       val lifecycleOwner: LifecycleOwner = viewCallback as LifecycleOwner):
        BasePresenter(lifecycleOwner) {
    interface ViewCallBack{

        fun setUpProgress()

        fun setUpFragments(bundle: Bundle?)

    }

    open fun onViewCreated(bundle: Bundle?){
        viewCallback.setUpFragments(bundle)
    }
}