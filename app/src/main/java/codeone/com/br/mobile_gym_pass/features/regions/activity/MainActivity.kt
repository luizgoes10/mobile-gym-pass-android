package codeone.com.br.mobile_gym_pass.features.regions.activity

import android.content.ClipData
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.view.menu.ExpandedMenuView
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.activity.BaseActivity
import codeone.com.br.mobile_gym_pass.features.company.adapter.EmpresaAdapter
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import codeone.com.br.mobile_gym_pass.features.regions.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_company.*
import org.jetbrains.anko.find

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, MainPresenter.ViewCallBack {

    private val presenter by lazy {MainPresenter(this)}
    private var adapter:EmpresaAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        presenter.onViewCreated()
    }

    override fun setUpRecycler() {
        rvCompany.layoutManager = LinearLayoutManager(this)
        rvCompany.itemAnimator = DefaultItemAnimator()
    }

    override fun setAllCompany(company: MutableList<Empresa>) {

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
        company ->  null
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
         /*   R.id.nav_region -> {

            }*/
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}
