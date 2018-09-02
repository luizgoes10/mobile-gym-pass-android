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
import java.util.LinkedHashMap

open class MainPresenter(val viewCallback: ViewCallBack, val lifecycleOwner: LifecycleOwner = viewCallback as LifecycleOwner):BasePresenter(lifecycleOwner) {
    interface ViewCallBack{

        fun setUpRecycler()
        fun setAllCompany(company:MutableList<Empresa>)
        fun setUpExpandableListView(parent:Array<String>,secondeLevel:MutableList<Array<String>>,
                                    data: MutableList<LinkedHashMap<String, Array<String>>>)
    }

    private var parent:Array<String> = arrayOf()//"What is View?", "What is  Layout?", "What is Dynamic Views?"
    internal var q1:Array<String> = arrayOf()//"List View", "Grid View"
    internal var q2:Array<String> = arrayOf() //"Linear Layout", "Relative Layout"
    internal var q3:Array<String> = arrayOf()//"Recycle View"
    internal var q4:Array<String> = arrayOf()
    internal var q5:Array<String> = arrayOf()
    internal var des1:Array<String> = arrayOf()//"A layout that organizes its children into a single horizontal or vertical row. It creates a scrollbar if the length of the window exceeds the length of the screen."
    internal var des2:Array<String> = arrayOf()//"Enables you to specify the location of child objects relative to each other (child A to the left of child B) or to the parent (aligned to the top of the parent)."
    internal var des3:Array<String> = arrayOf()//"This list contains linear layout information"
    internal var des4:Array<String> = arrayOf()//"This list contains relative layout information,Displays a scrolling grid of columns and rows"
    internal var des5:Array<String> = arrayOf()
    internal var des6:Array<String> = arrayOf()
    internal var des7:Array<String> = arrayOf()
    internal var des8:Array<String> = arrayOf()
    internal var des9:Array<String> = arrayOf()
    internal var des10:Array<String> = arrayOf()
    internal var des11:Array<String> = arrayOf()
    internal var des12:Array<String> = arrayOf()
    internal var des13:Array<String> = arrayOf()
    internal var des14:Array<String> = arrayOf()
    internal var des15:Array<String> = arrayOf()
    internal var des16:Array<String> = arrayOf()
    internal var des17:Array<String> = arrayOf()
    internal var des18:Array<String> = arrayOf()

    internal var thirdLevelq1 = LinkedHashMap<String, Array<String>>()
    internal var thirdLevelq2 = LinkedHashMap<String, Array<String>>()
    internal var thirdLevelq3 = LinkedHashMap<String, Array<String>>()
    /**
     * Second level array list
     */
    internal var secondLevel: MutableList<Array<String>> = ArrayList()
    /**
     * Inner level data
     */
    internal var data: MutableList<LinkedHashMap<String, Array<String>>> = ArrayList()

    open fun onViewCreated(){
        viewCallback.setUpRecycler()
        taskRegions()
    }

    open fun prepareMenuData(regions:List<Regiao>){

        parent = Array(regions.size, {i -> regions[i].nmRegiao})

        q1 = Array(regions[0].estado.size, { i -> regions[0].estado[i].nmEstado})

        q2 = Array(regions[1].estado.size, {i -> regions[1].estado[i].nmEstado})

        q3 = Array(regions[2].estado.size, {i -> regions[2].estado[i].nmEstado})

        q4 = Array(regions[3].estado.size, {i -> regions[3].estado[i].nmEstado})

        q5 = Array(regions[4].estado.size, {i -> regions[4].estado[i].nmEstado})

        des1 = Array(regions[0].estado[0].localizacao.size, { i ->
            regions[0].estado[0].localizacao[i].nmLocalizacao
        })

        des2 = Array(regions[0].estado[1].localizacao.size, { i ->
            regions[0].estado[1].localizacao[i].nmLocalizacao
        })

        des3 = Array(regions[0].estado[2].localizacao.size, { i ->
            regions[0].estado[2].localizacao[i].nmLocalizacao
        })

        des4 = Array(regions[1].estado[0].localizacao.size, { i ->
            regions[1].estado[0].localizacao[i].nmLocalizacao
        })

        des4 = Array(regions[1].estado[1].localizacao.size, { i ->
            regions[1].estado[1].localizacao[i].nmLocalizacao
        })

        des5 = Array(regions[1].estado[2].localizacao.size, { i ->
            regions[1].estado[2].localizacao[i].nmLocalizacao
        })

        des6 = Array(regions[1].estado[3].localizacao.size, { i ->
            regions[1].estado[3].localizacao[i].nmLocalizacao
        })

        secondLevel.add(q1)
        secondLevel.add(q2)
        secondLevel.add(q3)
        secondLevel.add(q4)
        secondLevel.add(q5)
        thirdLevelq1.put(q1[0], des1)
        thirdLevelq1.put(q1[1], des2)
        thirdLevelq1.put(q1[2], des3)
      /*  thirdLevelq2.put(q2[1], des4)
        thirdLevelq3.put(q3[2], des5)
        thirdLevelq3.put(q3[1], des6)*/
        data.add(thirdLevelq1)
        data.add(thirdLevelq2)
        data.add(thirdLevelq3)

        viewCallback.setUpExpandableListView(parent, secondLevel, data)
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
                    prepareMenuData(it)
                })
    }
}