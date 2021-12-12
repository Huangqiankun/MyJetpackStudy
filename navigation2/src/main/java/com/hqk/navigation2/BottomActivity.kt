package com.hqk.navigation2

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomActivity : AppCompatActivity() {
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom)

        val navView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        navController = Navigation.findNavController(this, R.id.fragmentContainerView)

        //监听页面切换
        navController?.addOnDestinationChangedListener { controller, destination, arguments ->
            Log.d("hqk", "onDestinationChanged")
        }

//        navView.setOnItemSelectedListener { item ->
//            if (item.itemId !== navView.selectedItemId) NavigationUI.onNavDestinationSelected(
//                item,
//                navController!!
//            )
//            true
//        }
        //底部菜单
        NavigationUI.setupWithNavController(
            findViewById<BottomNavigationView>(R.id.bottomNavigationView),
            navController!!
        );
    }


}