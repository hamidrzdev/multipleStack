package ir.ham.farzadnav.multipleFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.ham.farzadnav.databinding.FragmentContainerBinding

class ContainerFragment : Fragment() {
    private val TAG = ContainerFragment::class.java.simpleName
    private lateinit var binding: FragmentContainerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

        parentFragmentManager.addOnBackStackChangedListener {
            Log.i(TAG, "onViewCreated: stack: ${parentFragmentManager.backStackEntryCount}")
            Log.i(TAG, "onViewCreated: fragments: ${parentFragmentManager.fragments.size}")
        }
    }

    private fun initView() {
        loadFragment(container = binding.topLeft, title = "STACK 1")
        loadFragment(container = binding.topRight, title = "STACK 2")
        loadFragment(container = binding.bottomLeft, title = "STACK 3")
        loadFragment(container = binding.bottomRight, title = "STACK 4")
    }

    private fun loadFragment(container: ViewGroup, title: String) {
        val childFragment = ChildFragment.newInstance(title, 0)
        parentFragmentManager.beginTransaction()
            .replace(container.id, childFragment)
            .addToBackStack(childFragment::class.simpleName)
            .commit()
    }

    fun loadInnerFragment(title: String, count: Int) {
        val container = when (title) {
            "STACK 1" -> binding.topLeft
            "STACK 2" -> binding.topRight
            "STACK 3" -> binding.bottomLeft
            "STACK 4" -> binding.bottomRight
            else -> null
        } ?: return

        val childFragment = ChildFragment.newInstance(title, count)
        parentFragmentManager.beginTransaction()
            .replace(container.id, childFragment)
            .addToBackStack(childFragment::class.simpleName)
            .setPrimaryNavigationFragment(childFragment)
            .commit()
    }
}