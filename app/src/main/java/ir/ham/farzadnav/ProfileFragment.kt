package ir.ham.farzadnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.ham.farzadnav.databinding.FragmentDefaultBinding

class ProfileFragment :Fragment(){
    private lateinit var binding:FragmentDefaultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDefaultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nameTv.text = "PROFILE"
        binding.navigate.setOnClickListener {
            val destination1Fragment = Destination1Fragment()
            (requireActivity() as MainActivity).loadFragment(destination1Fragment)
        }

    }
}