package com.example.mvvmcleanarch.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.RepositoryItem
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.databinding.ItemTrendingRepoBinding
import com.example.mvvmcleanarch.extensions.loadImage
import java.util.*
import kotlin.reflect.KFunction2

class AdapterTrendingRepoList(
    val arrItems: ArrayList<RepositoryItem>,
    val onItemSelected: KFunction2<RepositoryItem, ImageView, Unit>
) :
    RecyclerView.Adapter<AdapterTrendingRepoList.ItemViewHolder>() {

    inner class ItemViewHolder(val itemTrendingRepoBinding: ItemTrendingRepoBinding) :
        RecyclerView.ViewHolder(itemTrendingRepoBinding.root) {
        init {
            itemTrendingRepoBinding.root.setOnClickListener {
                if (absoluteAdapterPosition != -1)
                    onItemSelected(
                        arrItems[absoluteAdapterPosition],
                        itemTrendingRepoBinding.ivAvatar
                    )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemTrendingRepoBinding>(
                layoutInflater,
                R.layout.item_trending_repo,
                parent,
                false
            )
        return ItemViewHolder(binding)

    }

    override fun getItemCount() = arrItems.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val context = holder.itemTrendingRepoBinding.root.context
        val item = arrItems[position]
        holder.itemTrendingRepoBinding.tvRepoName.text = item.repo
        holder.itemTrendingRepoBinding.ivAvatar.loadImage(context, item.avatars?.get(0))

    }

}