package ru.mokita.smartlab.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.mokita.data.network.SmartLabClient
import ru.mokita.smartlab.R
import ru.mokita.smartlab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        lifecycleScope.launchWhenStarted {
            mainViewModel.destination.collect{
                navController.navigate(mainViewModel.destination.value ?: R.id.action_splashFragment_to_onBoardFragment)
            }
        }
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    override fun onDestroy() {
        super.onDestroy()
        val id = navController.currentDestination?.id
        if (id != null) {
            mainViewModel.setDestination(id)
        }
    }
}