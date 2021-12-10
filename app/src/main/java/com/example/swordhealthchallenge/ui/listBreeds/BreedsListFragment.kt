package com.example.swordhealthchallenge.ui.listBreeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swordhealthchallenge.MainActivity
import com.example.swordhealthchallenge.R
import com.example.swordhealthchallenge.databinding.FragmentBreedsListBinding
import com.example.swordhealthchallenge.network.model.BreedModel
import com.example.swordhealthchallenge.network.resource.Status
import com.example.swordhealthchallenge.ui.listBreeds.adapter.BreedsListAdapter
import com.example.swordhealthchallenge.ui.listBreeds.viewModel.BreedsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedsListFragment : Fragment() {

    private lateinit var binding: FragmentBreedsListBinding
    private lateinit var listViewModel: BreedsListViewModel
    private lateinit var adapter: BreedsListAdapter
    private val list = mutableListOf<BreedModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_breeds_list, container, false)
        this.binding.funtion = this
        this.listViewModel = ViewModelProvider(this)[BreedsListViewModel::class.java]
        getBreeds()
        return this.binding.root
    }

    private fun getBreeds() {
        this.listViewModel.getBreeds().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        hideProgressBar()
                        it.data?.let { it1 -> this.list.addAll(it1) }
                        this.binding.rvListDogs.layoutManager = LinearLayoutManager(requireContext())
                        this.adapter = BreedsListAdapter(it.data as MutableList<BreedModel>, requireContext())
                        this.binding.rvListDogs.adapter = this.adapter
                    }
                    Status.ERROR -> {
                        hideProgressBar()
                        Toast.makeText(requireContext(), getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
                    }
                    Status.LOADING -> {
                        showProgressBar()
                    }
                }
            }
        })
    }

    fun setupGridLayoutRv() {
        this.binding.rvListDogs.layoutManager = GridLayoutManager(requireContext(), 2)
        this.adapter = BreedsListAdapter(this.list, requireContext())
        this.binding.rvListDogs.adapter = this.adapter
    }

    fun setupLinearLayoutRv() {
        this.binding.rvListDogs.layoutManager = LinearLayoutManager(requireContext())
        this.adapter = BreedsListAdapter(this.list, requireContext())
        this.binding.rvListDogs.adapter = this.adapter
    }

    private fun showProgressBar() {
        (requireActivity() as MainActivity).showProgressBar()
    }

    private fun hideProgressBar() {
        (requireActivity() as MainActivity).hideProgressBar()
    }

}