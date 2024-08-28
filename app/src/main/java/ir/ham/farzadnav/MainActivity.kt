package ir.ham.farzadnav

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ir.ham.farzadnav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    private lateinit var homeFragment: HomeFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHost.navController
        binding.bottomNav.setupWithNavController(navController)

//        onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                val selectedItemId = binding.bottomNav.selectedItemId
//
//                if (selectedItemId == R.id.profileFragment || selectedItemId == R.id.searchFragment|| selectedItemId == R.id.farzadFragment) {
//                    binding.bottomNav.selectedItemId = R.id.homeFragment
//                } else {
//                    finish()
//                }            }
//
//        })



    }

    private fun clearBackStack() {
        supportFragmentManager.popBackStack(HomeFragment::class.java.simpleName,FragmentManager.POP_BACK_STACK_INCLUSIVE)
//        supportFragmentManager.clearBackStack(HomeFragment::class.java.simpleName)
//        supportFragmentManager.clearBackStack("")
    }

    private fun selectBottomNavItem(fragment: Fragment){
        Log.i(TAG, "selectBottomNavItem: fragment: ${fragment::class.java.simpleName}")
        when(fragment){
            is HomeFragment -> {
//                if (binding.bottomNav.selectedItemId != R.id.home)
//                    binding.bottomNav.selectedItemId = R.id.home
            }
            is SearchFragment -> {
//                if (binding.bottomNav.selectedItemId != R.id.search)
//                    binding.bottomNav.selectedItemId = R.id.search
            }
            is ProfileFragment -> {
//                if (binding.bottomNav.selectedItemId != R.id.profile)
//                    binding.bottomNav.selectedItemId = R.id.profile
            }
        }
    }

    fun loadFragment(fragment: Fragment) {
        Log.i(TAG, "loadFragment: fragment: ${fragment::class.java.simpleName}")
        val transaction = supportFragmentManager.beginTransaction()

        transaction.addToBackStack(fragment::class.java.simpleName)

        transaction.replace(
            binding.fullContainer.id,
            fragment,
            fragment::class.java.simpleName
        )

        transaction.setPrimaryNavigationFragment(fragment)
        transaction.commit()
    }
}