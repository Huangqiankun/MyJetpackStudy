package com.hqk.navigation2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.NavController.OnDestinationChangedListener
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null
    private var appBarConfiguration: AppBarConfiguration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration.Builder(navController!!.graph).build()

        //显示可返回
        NavigationUI.setupActionBarWithNavController(
            this,
            navController!!, appBarConfiguration!!
        )

        //监听页面切换
        navController?.addOnDestinationChangedListener { controller, destination, arguments ->
            Log.d("hqk", "onDestinationChanged")
        }




    }

    //Action 菜单
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_settings, menu)
        return true
    }

    //Action Bar选中
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            navController!!
        ) || super.onOptionsItemSelected(item)
    }

    //解决不能返回
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navController!!,
            appBarConfiguration!!
        ) || super.onSupportNavigateUp()
    }
}