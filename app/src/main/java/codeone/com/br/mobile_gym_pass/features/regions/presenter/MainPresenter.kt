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


    private var auxChildList:HashMap<MenuModel, List<MenuModel>> = linkedMapOf()
    private var auxHeaderList:MutableList<MenuModel> = mutableListOf()
    private lateinit var auxChildModel:MenuModel
    private lateinit var auxChildModelList: MutableList<MenuModel>
    private lateinit var auxMenuModel: MenuModel

    private var headerList:MutableList<MenuModel> = mutableListOf()
    private var childList:HashMap<MenuModel, List<MenuModel>> = linkedMapOf()
    private lateinit var menuModel: MenuModel

    private lateinit var childModelList:MutableList<MenuModel>
    private lateinit var childModel:MenuModel

    open fun onViewCreated(){
        viewCallback.setUpRecycler()
        taskRegions()
    }

    open fun prepareMenuData(regions:List<Regiao>){

        regions.forEach{

            menuModel = MenuModel(it.nmRegiao, true, true,"")

            childModelList = mutableListOf()

            it.estado.forEach {

                auxMenuModel = MenuModel(it.nmEstado,true,true,"")

                childModel = MenuModel(it.nmEstado, true, true,"")

                childModelList?.add(childModel)

                auxChildModelList = mutableListOf()

                it.localizacao.forEach {

                   auxChildModel = MenuModel(it.nmLocalizacao, true,true,"")
                   auxChildModelList?.add(auxChildModel)
                }

                auxHeaderList?.add(auxMenuModel)
                auxChildList.put(auxMenuModel, auxChildModelList)
            }
            headerList?.add(menuModel)
            childList.put(menuModel, childModelList)
        }

        childList.forEach { t, u ->
            u.forEach {

            }
        }
       viewCallback.populateExpandebleList(headerList, childList)

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