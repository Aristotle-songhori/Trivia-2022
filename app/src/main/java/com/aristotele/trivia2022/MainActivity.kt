package com.aristotele.trivia2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.whenCreated

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
        // return super.onCreateOptionsMenu(menu)

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.nav_menu_1 -> Log.i("sexyLog","item1")
            R.id.nav_menu_2 -> Log.i("sexyLog","ite2")
            R.id.nav_menu_3 -> Log.i("sexyLog","item3")
        }
        return super.onOptionsItemSelected(item)

    }




}