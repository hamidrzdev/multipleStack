package ir.ham.farzadnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.ham.farzadnav.databinding.FragmentDestination1Binding


class Destination1Fragment : Fragment(){
    private lateinit var binding: FragmentDestination1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDestination1Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nameTv.text = "HOME 1"
        binding.navigate.setOnClickListener {
            val destination2Fragment = Destination2Fragment()
            (requireActivity() as MainActivity).loadFragment(destination2Fragment)
        }
    }
}