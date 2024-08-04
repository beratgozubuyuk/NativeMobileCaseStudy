package com.example.nativemobilecasestudy.view

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nativemobilecasestudy.adapter.ProductAdapter
import com.example.nativemobilecasestudy.viewmodel.HomeListViewModel
import com.example.nativemobilecasestudy.databinding.FragmentHomeListBinding

class HomeListFragment : Fragment() {
    private var _binding:FragmentHomeListBinding? = null
    private val binding get() = _binding!!

    private lateinit var productAdapter: ProductAdapter
    private lateinit var viewModel: HomeListViewModel

    companion object {
        fun newInstance() = HomeListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeListViewModel::class.java)

        binding.homeListRecyclerview.layoutManager = GridLayoutManager(context, 2)

        viewModel.products.observe(viewLifecycleOwner, { products ->
            if (products != null){
                productAdapter = ProductAdapter(products)
                binding.homeListRecyclerview.adapter = productAdapter
            }
        })

        viewModel.fetchProducts()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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