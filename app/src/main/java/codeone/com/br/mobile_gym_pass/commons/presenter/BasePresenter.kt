package codeone.com.br.mobile_gym_pass.commons.presenter

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter(lifecycleOwner: LifecycleOwner) : LifecycleObserver {

    val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    init {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        compositeDisposable.dispose()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        compositeDisposable.dispose()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        compositeDisposable.dispose()
    }

}