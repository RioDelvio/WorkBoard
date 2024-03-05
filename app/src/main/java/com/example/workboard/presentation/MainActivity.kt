package com.example.workboard.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.workboard.R
import com.example.workboard.databinding.ActivityMainBinding
import com.example.workboard.databinding.FragmentCreateTaskBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val component by lazy {
        (application as WorkBoardApp).component
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.fragmentHost)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.tasksFragment,
            R.id.notesFragment,
            R.id.wallFragment
        ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigationView.setupWithNavController(navController)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        NavigationUI.onNavDestinationSelected(item, findNavController(R.id.fragmentHost))
//        return super.onOptionsItemSelected(item)
//    }
}