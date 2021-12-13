package com.example.swordhealthchallenge.ui.searchForBreeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swordhealthchallenge.MainActivity
import com.example.swordhealthchallenge.R
import com.example.swordhealthchallenge.databinding.FragmentSearchForBreedsBinding
import com.example.swordhealthchallenge.network.model.BreedDetailsModel
import com.example.swordhealthchallenge.network.resource.Status
import com.example.swordhealthchallenge.ui.searchForBreeds.adapter.SearchForBreedsAdapter
import com.example.swordhealthchallenge.ui.searchForBreeds.viewModel.SearchForBreedsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchForBreedsFragment : Fragment() {

    private lateinit var binding: FragmentSearchForBreedsBinding
    private lateinit var viewModel: SearchForBreedsViewModel
    private lateinit var adapter: SearchForBreedsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_for_breeds, container, false)
        this.binding.function = this
        this.viewModel = ViewModelProvider(this)[SearchForBreedsViewModel::class.java]
        return this.binding.root
    }

    fun onSearchBreedName() {
        val name = this.binding.editTextTextPersonName.text
        if (name.isNullOrBlank()) {
            return
        }
        getBreedDetails(name.trim().toString())
    }

    private fun getBreedDetails(name: String) {
        this.viewModel.getBreedDetails(requireContext(), name).observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        hideProgressBar()
                        it.data?.let { it1 -> setupRv(it1) }
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

    private fun setupRv(data: List<BreedDetailsModel>) {
        this.binding.rvBreedsSearched.layoutManager = LinearLayoutManager(requireContext())
        this.adapter = SearchForBreedsAdapter(data as MutableList<BreedDetailsModel>, requireContext(),this)
        this.binding.rvBreedsSearched.adapter = this.adapter
    }

    private fun showProgressBar() {
        (requireActivity() as MainActivity).showProgressBar()
    }

    private fun hideProgressBar() {
        (requireActivity() as MainActivity).hideProgressBar()
    }

}