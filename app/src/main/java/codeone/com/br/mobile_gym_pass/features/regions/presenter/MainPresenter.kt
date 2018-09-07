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
        fun setUpProgress(show:Boolean)
        fun setUpSwipe()
        fun setUpAlertDialog(message:String)
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
    internal var des19:Array<String> = arrayOf()
    internal var des20:Array<String> = arrayOf()
    internal var des21:Array<String> = arrayOf()
    internal var des22:Array<String> = arrayOf()
    internal var des23:Array<String> = arrayOf()
    internal var des24:Array<String> = arrayOf()
    internal var des25:Array<String> = arrayOf()
    internal var des26:Array<String> = arrayOf()
    internal var des27:Array<String> = arrayOf()


    internal var thirdLevelq1 = LinkedHashMap<String, Array<String>>()
    internal var thirdLevelq2 = LinkedHashMap<String, Array<String>>()
    internal var thirdLevelq3 = LinkedHashMap<String, Array<String>>()

    internal var thirdLevelq4 = LinkedHashMap<String, Array<String>>()
    internal var thirdLevelq5 = LinkedHashMap<String, Array<String>>()
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
            regions[0].estado[0].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[0].estado[0].localizacao[i].nmLocalizacao
        })

        des2 = Array(regions[0].estado[1].localizacao.size, { i ->
            regions[0].estado[1].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[0].estado[1].localizacao[i].nmLocalizacao
        })

        des3 = Array(regions[0].estado[2].localizacao.size, { i ->
            regions[0].estado[2].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[0].estado[2].localizacao[i].nmLocalizacao
        })

        des4 = Array(regions[1].estado[0].localizacao.size, { i ->
            regions[1].estado[0].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[1].estado[0].localizacao[i].nmLocalizacao
        })

        des5 = Array(regions[1].estado[1].localizacao.size, { i ->
            regions[1].estado[1].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[1].estado[1].localizacao[i].nmLocalizacao
        })

        des6 = Array(regions[1].estado[2].localizacao.size, { i ->
            regions[1].estado[2].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[1].estado[2].localizacao[i].nmLocalizacao
        })

        des7 = Array(regions[1].estado[3].localizacao.size, { i ->
            regions[1].estado[3].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[1].estado[3].localizacao[i].nmLocalizacao
        })

        des8 = Array(regions[2].estado[0].localizacao.size, {i ->
            regions[2].estado[0].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[2].estado[0].localizacao[i].nmLocalizacao
        })

        des9 = Array(regions[2].estado[1].localizacao.size,{ i ->
            regions[2].estado[1].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[2].estado[1].localizacao[i].nmLocalizacao
        })

        des10 = Array(regions[2].estado[2].localizacao.size,{ i ->
            regions[2].estado[2].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[2].estado[2].localizacao[i].nmLocalizacao
        })

        des11 = Array(regions[2].estado[3].localizacao.size, { i ->
            regions[2].estado[3].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[2].estado[3].localizacao[i].nmLocalizacao
        })

        des12 = Array(regions[2].estado[4].localizacao.size, {i ->
            regions[2].estado[4].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[2].estado[4].localizacao[i].nmLocalizacao
        })

        des13 = Array(regions[2].estado[5].localizacao.size,{ i ->
            regions[2].estado[5].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[2].estado[5].localizacao[i].nmLocalizacao
        })

        des14 = Array(regions[2].estado[6].localizacao.size,{ i ->
            regions[2].estado[6].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[2].estado[6].localizacao[i].nmLocalizacao
        })

        des15 = Array(regions[2].estado[7].localizacao.size, { i ->
            regions[2].estado[7].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[2].estado[7].localizacao[i].nmLocalizacao
        })

        des16 = Array(regions[2].estado[8].localizacao.size, { i ->
            regions[2].estado[8].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[2].estado[8].localizacao[i].nmLocalizacao
        })

        des17 = Array(regions[3].estado[0].localizacao.size, { i ->
            regions[3].estado[0].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[3].estado[0].localizacao[i].nmLocalizacao
        })

        des18 = Array(regions[3].estado[1].localizacao.size, { i ->
            regions[3].estado[1].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[3].estado[1].localizacao[i].nmLocalizacao
        })

        des19 = Array(regions[3].estado[2].localizacao.size, { i ->
            regions[3].estado[2].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[3].estado[2].localizacao[i].nmLocalizacao
        })

        des20 = Array(regions[3].estado[3].localizacao.size, { i ->
            regions[3].estado[3].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[3].estado[3].localizacao[i].nmLocalizacao
        })

        des21 = Array(regions[4].estado[0].localizacao.size, { i ->
            regions[4].estado[0].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[4].estado[0].localizacao[i].nmLocalizacao
        })

        des22 = Array(regions[4].estado[1].localizacao.size, { i ->
            regions[4].estado[1].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[4].estado[1].localizacao[i].nmLocalizacao
        })

        des23 = Array(regions[4].estado[2].localizacao.size, { i ->
            regions[4].estado[2].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[4].estado[2].localizacao[i].nmLocalizacao
        })

        des24 = Array(regions[4].estado[3].localizacao.size, { i ->
            regions[4].estado[3].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[4].estado[3].localizacao[i].nmLocalizacao
        })

        des25 = Array(regions[4].estado[4].localizacao.size, { i ->
            regions[4].estado[4].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[4].estado[4].localizacao[i].nmLocalizacao
        })

        des26 = Array(regions[4].estado[5].localizacao.size, { i ->
            regions[4].estado[5].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[4].estado[5].localizacao[i].nmLocalizacao
        })

        des27 = Array(regions[4].estado[6].localizacao.size, { i ->
            regions[4].estado[6].localizacao[i].idLocalizacao.toString() + " " + "-" + " " +
                    regions[4].estado[6].localizacao[i].nmLocalizacao
        })


        secondLevel.add(q1)
        secondLevel.add(q2)
        secondLevel.add(q3)
        secondLevel.add(q4)
        secondLevel.add(q5)
//sul
        thirdLevelq1.put(q1[0], des1)
        thirdLevelq1.put(q1[1], des2)
        thirdLevelq1.put(q1[2], des3)

//sudeste
        thirdLevelq2.put(q2[0], des4)
        thirdLevelq2.put(q2[1], des5)
        thirdLevelq2.put(q2[2], des6)
        thirdLevelq2.put(q2[3], des7)

//nordeste
        thirdLevelq3.put(q3[0], des8)
        thirdLevelq3.put(q3[1], des9)
        thirdLevelq3.put(q3[2], des10)
        thirdLevelq3.put(q3[3], des11)
        thirdLevelq3.put(q3[4], des12)
        thirdLevelq3.put(q3[5], des13)
        thirdLevelq3.put(q3[6], des14)
        thirdLevelq3.put(q3[7], des15)
        thirdLevelq3.put(q3[8], des16)

//centro-oeste
        thirdLevelq4.put(q4[0], des17)
        thirdLevelq4.put(q4[1], des18)
        thirdLevelq4.put(q4[2], des19)
        thirdLevelq4.put(q4[3], des20)
//norte
        thirdLevelq5.put(q5[0], des21)
        thirdLevelq5.put(q5[1], des22)
        thirdLevelq5.put(q5[2], des23)
        thirdLevelq5.put(q5[3], des24)
        thirdLevelq5.put(q5[4], des25)
        thirdLevelq5.put(q5[5], des26)
        thirdLevelq5.put(q5[6], des27)

        data.add(thirdLevelq1)
        data.add(thirdLevelq2)
        data.add(thirdLevelq3)
        data.add(thirdLevelq4)
        data.add(thirdLevelq5)

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
                    //Curitiba e região
                    viewCallback.setUpProgress(true)
                    viewCallback.setAllCompany(it[0].estado[0].localizacao[0].empresa)
                    prepareMenuData(it)
                    viewCallback.setUpSwipe()
                },onComplete = {
                    viewCallback.setUpProgress(false)
                },onError = {
                    viewCallback.setUpProgress(true)
                    viewCallback.setUpAlertDialog(it.message!!)
                }
                        )
    }
    open fun taskCompanyByIdLocation(id:Int){
        Observable.fromCallable { AllObjectService.getCompanyByIdLocation(id) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(onNext = {
                    if(it.isEmpty()){
                        return@subscribeBy
                    }
                    viewCallback.setUpProgress(true)
                    viewCallback.setAllCompany(it)
                    viewCallback.setUpSwipe()
                },onComplete = {
                    viewCallback.setUpProgress(false)
                },onError = {
                    viewCallback.setUpProgress(true)
                    viewCallback.setUpAlertDialog(it.message!!)
                }
                )
    }
}