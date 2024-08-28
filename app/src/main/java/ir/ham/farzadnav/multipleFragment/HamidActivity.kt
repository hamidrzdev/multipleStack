package ir.ham.farzadnav.multipleFragment

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import ir.ham.farzadnav.databinding.HamidActivityBinding

class HamidActivity: AppCompatActivity(){
    private val TAG = HamidActivity::class.java.simpleName
    private lateinit var binding: HamidActivityBinding

    val containerFragment = ContainerFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HamidActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        loadFragment()
    }

    private fun loadFragment(){
        supportFragmentManager.beginTransaction()
            .replace(binding.root.id, containerFragment)
            .addToBackStack(ContainerFragment::class.simpleName)
            .commit()
    }
}