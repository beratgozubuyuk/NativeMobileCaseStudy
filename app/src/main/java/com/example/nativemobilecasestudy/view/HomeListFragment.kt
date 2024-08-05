package com.example.nativemobilecasestudy.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nativemobilecasestudy.adapter.ProductAdapter
import com.example.nativemobilecasestudy.viewmodel.HomeListViewModel
import com.example.nativemobilecasestudy.databinding.FragmentHomeListBinding
import com.example.nativemobilecasestudy.viewmodel.HomeListViewModelFactory

class HomeListFragment : Fragment() {
    private var _binding: FragmentHomeListBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeListViewModel: HomeListViewModel
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productAdapter = ProductAdapter { product ->
            val action = HomeListFragmentDirections.actionHomeListFragmentToProductDetailFragment(product.id)
            findNavController().navigate(action)
        }

        binding.homeListRecyclerview.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = productAdapter
        }

        val factory = HomeListViewModelFactory(requireActivity().application)
        homeListViewModel = ViewModelProvider(this, factory).get(HomeListViewModel::class.java)

        homeListViewModel.products.observe(viewLifecycleOwner) { products ->
            productAdapter.setProducts(products)
        }

        homeListViewModel.fetchProducts()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}