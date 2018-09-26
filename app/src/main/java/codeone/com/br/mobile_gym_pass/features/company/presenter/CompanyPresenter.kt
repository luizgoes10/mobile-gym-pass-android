package codeone.com.br.mobile_gym_pass.features.company.presenter

import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import codeone.com.br.mobile_gym_pass.commons.domain.Geocode
import codeone.com.br.mobile_gym_pass.commons.presenter.BasePresenter
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import codeone.com.br.mobile_gym_pass.features.company.service.MapsService
import codeone.com.br.mobile_gym_pass.features.regions.domain.Box
import codeone.com.br.mobile_gym_pass.features.regions.presenter.MainPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

open class CompanyPresenter(val viewCallback: CompanyPresenter.ViewCallBack,
                       val lifecycleOwner: LifecycleOwner = viewCallback as LifecycleOwner):
        BasePresenter(lifecycleOwner) {
    interface ViewCallBack{

        fun setUpFragments(bundle: Bundle?)

        fun setUpMapsFragment(bundle: Bundle)



    }

    open fun onViewCreated(bundle: Bundle?, empresa: Empresa){
        taskGeocode(bundle,empresa.addrEndereco)
        viewCallback.setUpFragments(bundle)
    }
    open fun taskGeocode(bundle: Bundle?,address:String){
        Observable.fromCallable { MapsService.getGeocodeLocation(address) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy( onNext = {
                    if(it == null){
                        return@subscribeBy
                    }
                    viewCallback.setUpMapsFragment(setBundleGeocode(it))

                }, onComplete = {

                }, onError = {

                })
    }

    private fun setBundleGeocode(geocode: Geocode):Bundle{
        val bundle = Bundle()
        bundle.putParcelable("geocode", geocode)
        return bundle
    }
}