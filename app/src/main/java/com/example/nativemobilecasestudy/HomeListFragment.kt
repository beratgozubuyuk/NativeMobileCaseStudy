package com.example.nativemobilecasestudy

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nativemobilecasestudy.databinding.FragmentHomeListBinding

class HomeListFragment : Fragment() {
    private var _binding:FragmentHomeListBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = HomeListFragment()
    }

    private val viewModel: HomeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}