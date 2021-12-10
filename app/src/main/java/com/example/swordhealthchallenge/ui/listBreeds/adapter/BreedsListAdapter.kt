package com.example.swordhealthchallenge.ui.listBreeds.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.swordhealthchallenge.R
import com.example.swordhealthchallenge.databinding.BreedItemPreviewBinding
import com.example.swordhealthchallenge.network.model.BreedModel

class BreedsListAdapter(
    private val list: MutableList<BreedModel>,
    private val context: Context
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BreedsListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.breed_item_preview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BreedsListViewHolder).bind(this.list[position], this.context)
    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}

class BreedsListViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val binding = BreedItemPreviewBinding.bind(this.itemView)

    fun bind(breedModel: BreedModel, context: Context) {
        this.binding.progressBar.visibility = View.VISIBLE
        this.binding.breedNameTxt.visibility = View.GONE
        this.binding.view.visibility = View.GONE

        this.binding.breedNameTxt.text = breedModel.name

        Glide.with(context)
            .load(breedModel.image.url)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.progressBar.visibility = View.GONE
                    binding.view.setBackgroundColor(Color.parseColor("#7F000000"))
                    binding.view.visibility = View.VISIBLE
                    binding.breedNameTxt.visibility = View.VISIBLE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.progressBar.visibility = View.GONE
                    binding.view.setBackgroundColor(Color.parseColor("#7F000000"))
                    binding.view.visibility = View.VISIBLE
                    binding.breedNameTxt.visibility = View.VISIBLE
                    return false
                }
            })
            .error(R.drawable.ic_launcher_background)
            .into(this.binding.imageView2)
    }
}