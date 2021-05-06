package com.mobiquity.weatherapp.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.mobiquity.weatherapp.R
import com.mobiquity.weatherapp.ui.fragment.HelpFragment
import com.mobiquity.weatherapp.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setToolbarStyleWithCoordinatorLayout()

        // set main fragment
        changeFragment(HomeFragment(), R.id.mainContainer, null)

        fab.setOnClickListener {
            // handlef fab button click at help fragment
            val fragment: HomeFragment? = supportFragmentManager.findFragmentByTag(HomeFragment().javaClass.name) as HomeFragment?
            if (fragment != null && fragment.isVisible()) {
                fragment.myAdapter.addItem("Hyderabad")
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            R.id.menuHelpText -> {
                changeFragment(HelpFragment(), R.id.mainContainer, null)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (this.supportFragmentManager.backStackEntryCount > 0) {
            this.supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    private fun setToolbarStyleWithCoordinatorLayout() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressed() }
        toolbar_layout.title = ""
    }
}