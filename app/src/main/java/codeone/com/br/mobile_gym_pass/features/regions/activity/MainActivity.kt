package codeone.com.br.mobile_gym_pass.features.regions.activity

import android.os.Bundle
import android.os.Handler
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ExpandableListView
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.activity.BaseActivity
import codeone.com.br.mobile_gym_pass.commons.util.alert
import codeone.com.br.mobile_gym_pass.commons.util.setupToolbar
import codeone.com.br.mobile_gym_pass.features.company.adapter.EmpresaAdapter
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import codeone.com.br.mobile_gym_pass.features.regions.adapter.ThreeLevelListAdapter
import codeone.com.br.mobile_gym_pass.features.regions.presenter.MainPresenter
import java.util.LinkedHashMap
import codeone.com.br.mobile_gym_pass.features.company.activity.CompanyActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_company.*
import kotlinx.android.synthetic.main.include_toolbar.*
import org.jetbrains.anko.startActivity

class MainActivity() : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, MainPresenter.ViewCallBack {

    open val presenter by lazy {MainPresenter(this)}
    private var adapter:EmpresaAdapter? = null

    private var expandableListView: ExpandableListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar(R.id.myToolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        presenter.onViewCreated()

    }


    override fun setUpRecycler() {
        rvCompany.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        rvCompany.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
    }

    override fun setUpProgress(show:Boolean) {
        if(show)
           pbRecyclerCompany.visibility = View.VISIBLE
        else{
            pbRecyclerCompany.visibility = View.GONE
        }
    }

    override fun setUpAlertDialog(message: String) {

        alert("Houve um erro",message)

    }

    override fun setUpSwipe() {
        srCompany.setOnRefreshListener {
            // Your code here
            // To keep animation for 4 seconds
            Handler().postDelayed(Runnable {
                // Stop animation (This will be after 3 seconds)
                srCompany.setRefreshing(false)
            }, 4000) // Delay in millis
        }
    }

    override fun setAllCompany(company: List<Empresa>) {


        rvCompany.visibility = View.VISIBLE
        if(adapter == null){
            adapter = EmpresaAdapter(this, company, onClickItem())
            rvCompany.adapter = adapter
        }else{
            adapter?.setList(company)
            adapter?.notifyDataSetChanged()
        }
    }

    private fun onClickItem():(Empresa) -> Unit = {
        startActivity<CompanyActivity>("empresa" to it)
    }
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
         /*   R.id.rowThirdText -> {
              toast("ok")
            }*/
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun setUpExpandableListView(parent:Array<String>,secondeLevel:MutableList<Array<String>>,
                                         data: MutableList<LinkedHashMap<String, Array<String>>>) {
        expandableListView = findViewById(R.id.expandible_listview) as ExpandableListView
        //passing three level of information to constructor
        val threeLevelListAdapterAdapter = ThreeLevelListAdapter(this, parent, secondeLevel, data)
        expandableListView?.setAdapter(threeLevelListAdapterAdapter)
        expandableListView?.setOnGroupExpandListener(object : ExpandableListView.OnGroupExpandListener {
            internal var previousGroup = -1

            override fun onGroupExpand(groupPosition: Int) {
                if (groupPosition != previousGroup)
                    expandableListView?.collapseGroup(previousGroup)
                previousGroup = groupPosition

            }

        })

    }


}
