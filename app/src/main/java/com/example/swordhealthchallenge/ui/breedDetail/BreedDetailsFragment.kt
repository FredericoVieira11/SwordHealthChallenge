package com.example.swordhealthchallenge.ui.breedDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.swordhealthchallenge.MainActivity
import com.example.swordhealthchallenge.R
import com.example.swordhealthchallenge.databinding.FragmentBreedDetailsBinding
import com.example.swordhealthchallenge.network.resource.Status
import com.example.swordhealthchallenge.ui.breedDetail.viewModel.BreedDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedDetailsFragment : Fragment() {

    private lateinit var binding: FragmentBreedDetailsBinding
    private lateinit var viewModel: BreedDetailsViewModel
    private val args: BreedDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_breed_details, container, false)
        this.viewModel = ViewModelProvider(this)[BreedDetailsViewModel::class.java]
        getBreedDetails()
        return this.binding.root
    }

    private fun getBreedDetails() {
        this.viewModel.getBreedDetails(requireContext(), this.args.passingName).observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        hideProgressBar()
                        this.binding.breedDetailNameTxt.text = if (it.data?.get(0)?.name == null || it.data[0].name.equals("")) getString(R.string.empty_value) else it.data[0].name
                        this.binding.breedDetailCategoryTxt.text = getString(R.string.none)
                        this.binding.breedDetailOriginTxt.text = if (it.data?.get(0)?.origin == null || it.data[0].origin.equals("")) getString(R.string.empty_value) else it.data[0].origin
                        this.binding.breedDetailTemperamentTxt.text = if (it.data?.get(0)?.temperament == null || it.data[0].temperament.equals("")) getString(R.string.empty_value) else it.data[0].temperament
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

    private fun showProgressBar() {
        (requireActivity() as MainActivity).showProgressBar()
    }

    private fun hideProgressBar() {
        (requireActivity() as MainActivity).hideProgressBar()
    }

}