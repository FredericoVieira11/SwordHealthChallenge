package com.example.swordhealthchallenge.ui.searchForBreeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.swordhealthchallenge.R
import com.example.swordhealthchallenge.databinding.FragmentSearchForBreedsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchForBreedsFragment : Fragment() {

    private var _binding: FragmentSearchForBreedsBinding? = null
    private val binding get() = this._binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this._binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_for_breeds, container, false)
        return this.binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        this._binding = null
    }

}