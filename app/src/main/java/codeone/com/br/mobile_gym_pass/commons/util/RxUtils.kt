package codeone.com.br.mobile_gym_pass.commons.util

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import android.support.annotation.CallSuper
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.exceptions.OnErrorNotImplementedException
import io.reactivex.plugins.RxJavaPlugins

private val onNextStub: (Any) -> Unit = {}
private val onErrorStub: (Throwable) -> Unit = { RxJavaPlugins.onError(OnErrorNotImplementedException(it)) }
private val onCompleteStub: () -> Unit = {}

open class ObservableAware<T>(val compositeDisposable: CompositeDisposable, val lifecycleOwner: LifecycleOwner) : Observer<T>, LifecycleObserver {
    lateinit var disposable: Disposable
    init {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    @CallSuper
    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

    override fun onNext(t: T) {
        compositeDisposable.add(disposable)
    }

    override fun onError(e: Throwable) {}

    override fun onComplete() {}

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

fun <T : Any> Observable<T>.subscribeAwareBy(compositeDisposable: CompositeDisposable,
                                             lifecycleOwner: LifecycleOwner,
                                             onError: (Throwable) -> Unit = onErrorStub,
                                             onComplete: () -> Unit = onCompleteStub,
                                             onNext: (T) -> Unit = onNextStub) {
    this.subscribe(object: ObservableAware<T>(compositeDisposable, lifecycleOwner) {
        override fun onNext(t: T) {
            super.onNext(t)
            if (lifecycleOwner.lifecycle.currentState != android.arch.lifecycle.Lifecycle.State.DESTROYED) {
                onNext(t)
            }
        }

        override fun onError(e: Throwable) {
            super.onError(e)
            if (lifecycleOwner.lifecycle.currentState != android.arch.lifecycle.Lifecycle.State.DESTROYED) {
                onError(e)
            }
        }

        override fun onComplete() {
            super.onComplete()
            if (lifecycleOwner.lifecycle.currentState != android.arch.lifecycle.Lifecycle.State.DESTROYED) {
                onComplete()
            }
        }
    })
}