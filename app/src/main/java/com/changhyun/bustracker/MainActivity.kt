package com.changhyun.bustracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.ButtonBarLayout
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {

    private lateinit var drawer : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        renderToolbar()
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
            return
        }
        super.onBackPressed()

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