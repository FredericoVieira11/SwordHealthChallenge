package com.example.swordhealthchallenge.ui.searchForBreeds.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.swordhealthchallenge.R
import com.example.swordhealthchallenge.databinding.BreedSearchedPreviewBinding
import com.example.swordhealthchallenge.network.model.BreedDetailsModel
import com.example.swordhealthchallenge.ui.searchForBreeds.SearchForBreedsFragmentDirections

class SearchForBreedsAdapter(
    private val list: MutableList<BreedDetailsModel>,
    private val context: Context,
    private val fragment: Fragment
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SearchForBreedsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.breed_searched_preview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SearchForBreedsViewHolder).bind(this.list[position], this.context)

        holder.itemView.setOnClickListener {
            val name = this.list[position].name

            val action = name?.let { it1 ->
                SearchForBreedsFragmentDirections.actionSearchDogsFragmentToBreedDetailFragment(
                    it1
                )
            }
            if (action != null) {
                NavHostFragment.findNavController(this.fragment).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}

class SearchForBreedsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val binding = BreedSearchedPreviewBinding.bind(itemView)

    fun bind(breedDetailsModel: BreedDetailsModel, context: Context) {
        this.binding.breedSearchedName.text = if (breedDetailsModel.name.isNullOrEmpty()) context.getString(R.string.empty_value) else breedDetailsModel.name
        this.binding.breedSearchedGroup.text = if (breedDetailsModel.group.isNullOrEmpty()) context.getString(R.string.empty_value) else breedDetailsModel.group
        this.binding.breedSearchedOrigin.text = if (breedDetailsModel.origin.isNullOrEmpty()) context.getString(R.string.empty_value) else breedDetailsModel.origin
    }
}