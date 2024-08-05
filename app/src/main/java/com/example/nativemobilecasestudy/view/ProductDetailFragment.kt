package com.example.nativemobilecasestudy.view

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.nativemobilecasestudy.R
import com.example.nativemobilecasestudy.viewmodel.ProductDetailViewModel
import com.example.nativemobilecasestudy.databinding.FragmentProductDetailBinding
import com.example.nativemobilecasestudy.viewmodel.HomeListViewModel

class ProductDetailFragment : Fragment() {
    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ProductDetailViewModel

    companion object {
        fun newInstance() = ProductDetailFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ProductDetailViewModel::class.java)

        val args = ProductDetailFragmentArgs.fromBundle(requireArguments())
        val productId = args.productId

        viewModel.getProduct(productId)
        viewModel.product.observe(viewLifecycleOwner){product ->
            product?.let {
                binding.productName.text = it.name
                binding.productPrice.text = it.price+" TL"
                binding.productDescription.text = it.description
                if (it.imageUrl != null) {
                    Glide.with(binding.productImage.context)
                        .load(it.imageUrl)
                        .into(binding.productImage)
                } else {
                    binding.productImage.setImageResource(R.drawable.people)
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}