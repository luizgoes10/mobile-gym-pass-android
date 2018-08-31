package codeone.com.br.mobile_gym_pass.features.regions.presenter

import android.arch.lifecycle.LifecycleOwner
import codeone.com.br.mobile_gym_pass.commons.presenter.BasePresenter
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import codeone.com.br.mobile_gym_pass.features.regions.domain.Regiao
import codeone.com.br.mobile_gym_pass.features.regions.domain.util.MenuModel
import codeone.com.br.mobile_gym_pass.features.regions.service.AllObjectService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

open class MainPresenter(val viewCallback: ViewCallBack, val lifecycleOwner: LifecycleOwner = viewCallback as LifecycleOwner):BasePresenter(lifecycleOwner) {
    interface ViewCallBack{

        fun setUpRecycler()
        fun setAllCompany(company:MutableList<Empresa>)
        fun setExpandableList(regions: MutableList<Regiao>)
        fun populateExpandebleList(headerList:List<MenuModel>, childList:HashMap<MenuModel, List<MenuModel>>)
    }

    private var headerList:MutableList<MenuModel> = mutableListOf()
    private var childList:HashMap<MenuModel, List<MenuModel>> = linkedMapOf()

    open fun onViewCreated(){
        viewCallback.setUpRecycler()
        taskRegions()
    }

    open fun prepareMenuData(regions:List<Regiao>){

        regions.forEach{
            var menuModel = MenuModel(it.nmRegiao, true, true,"")
            var chilModelList:MutableList<MenuModel> = mutableListOf()
            it.estado.forEach {
                var childModel = MenuModel(it.nmEstado, false, false,"")
                chilModelList?.add(childModel)
            }
            headerList?.add(menuModel)
            childList.put(menuModel, chilModelList)
        }
        viewCallback.populateExpandebleList(headerList,childList)
    }
    open fun taskRegions(){

        Observable.fromCallable{ AllObjectService.getAllRegions() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(onNext = {
                    if(it.isEmpty()){
                        return@subscribeBy
                    }

                    viewCallback.setAllCompany(it[0].estado[0].localizacao[0].empresa)
                    viewCallback.setExpandableList(it)
                })
    }
}