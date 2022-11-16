package com.changhyun.bustracker

import Adapters.ViewPagerAdapter
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.TypedValue
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.ButtonBarLayout
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var drawer : DrawerLayout
    private lateinit var viewPager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
            return
        }
        super.onBackPressed()

    }

    private fun init(){
        renderToolbar()
        renderViewPager()

    }

    private fun renderViewPager(){
        viewPager = findViewById<ViewPager2>(R.id.viewpager)
        val dip = 14f
        val r: Resources = resources
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dip,
            r.displayMetrics
        ).toInt()
        viewPager.setPageTransformer(MarginPageTransformer(px))
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter
    }

    private fun renderToolbar(){
        val tb = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(tb)

        drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        val toggle = ActionBarDrawerToggle(this, drawer, tb,
            R.string.nav_drawer_open, R.string.nav_drawer_close)

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val searchView = findViewById<SearchView>(R.id.search_view)
        val editButton = findViewById<Button>(R.id.edit_button)

        editButton.setOnClickListener{
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        }

    }
}