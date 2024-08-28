package ir.ham.farzadnav.multipleFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.BackEventCompat
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import ir.ham.farzadnav.databinding.FragmentChildBinding
import ir.ham.farzadnav.databinding.FragmentDefaultBinding

class ChildFragment :Fragment(){
    private val TAG = ChildFragment::class.java.simpleName
    private lateinit var binding: FragmentChildBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChildBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()


//        requireActivity().onBackPressedDispatcher.addCallback(object :OnBackPressedCallback(true){
//            override fun handleOnBackPressed() {
//                val stackCount = parentFragmentManager.backStackEntryCount
//                Log.i(TAG, "handleOnBackPressed: stackCount: $stackCount")
//                parentFragmentManager.popBackStack()
//            }
//
//            override fun handleOnBackStarted(backEvent: BackEventCompat) {
//                super.handleOnBackStarted(backEvent)
//            }
//        })
    }

    private fun initView() {
        val title = requireArguments().getString("title","")
        val innerFragmentsCount = requireArguments().getInt("count",0)
        binding.title.text = title
        binding.count.text = innerFragmentsCount.toString()

        binding.root.setOnClickListener {
            (requireActivity() as HamidActivity).containerFragment.loadInnerFragment(title = title, count = innerFragmentsCount + 1)

//            val fragment = newInstance(title = title, count = innerFragmentsCount + 1)
//            childFragmentManager.beginTransaction()
//                .replace(binding.root.id, fragment)
//                .addToBackStack(fragment::class.simpleName)
//                .commit()
        }
    }

    companion object {
        fun newInstance(title: String, count:Int): ChildFragment{
            val args = Bundle()
            args.putString("title", title)
            args.putInt("count", count)
            val fragment = ChildFragment()
            fragment.arguments = args
            return fragment
        }
    }
}