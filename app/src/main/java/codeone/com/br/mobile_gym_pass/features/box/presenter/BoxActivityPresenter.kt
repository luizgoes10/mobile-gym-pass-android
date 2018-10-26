package codeone.com.br.mobile_gym_pass.features.box.presenter

import android.annotation.SuppressLint
import androidx.lifecycle.LifecycleOwner
import codeone.com.br.mobile_gym_pass.commons.presenter.BasePresenter
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

open class BoxActivityPresenter(val viewCallBack: BoxActivityPresenter.ViewCallBack,
                                val lifecycleOwner: LifecycleOwner = viewCallBack as LifecycleOwner):
        BasePresenter(lifecycleOwner)   {
    interface ViewCallBack{

        fun setUpExpandebleImage()
        fun setUpFragmentPeriodo()
        fun setUpFragmentBox()
        fun setUpFragmentImageBox()
    }

    @SuppressLint("CheckResult")
    open fun onViewCreated(){
        Observable.fromCallable {

        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            viewCallBack.setUpExpandebleImage()
                            viewCallBack.setUpFragmentImageBox()
                            viewCallBack.setUpFragmentBox()
                            viewCallBack.setUpFragmentPeriodo()
                        }
                )
    }
}