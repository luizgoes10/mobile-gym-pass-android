package codeone.com.br.mobile_gym_pass.features.all_objects.presenter

import android.arch.lifecycle.LifecycleOwner
import codeone.com.br.mobile_gym_pass.commons.presenter.BasePresenter
import codeone.com.br.mobile_gym_pass.features.all_objects.service.AllObjectService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

open class MainPresenter(val viewCallback: ViewCallBack, val lifecycleOwner: LifecycleOwner = viewCallback as LifecycleOwner):BasePresenter(lifecycleOwner) {
    interface ViewCallBack{

    }

    open fun taskRegions(){

        Observable.fromCallable{ AllObjectService.getAllRegions() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(onNext = {
                    if(it.isEmpty()){
                        return@subscribeBy
                    }
                })
    }
}