package codeone.com.br.mobile_gym_pass.commons.presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
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