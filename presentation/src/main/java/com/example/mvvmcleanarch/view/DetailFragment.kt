package com.example.mvvmcleanarch.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.transition.TransitionInflater
import androidx.viewbinding.ViewBinding
import com.example.domain.model.RepositoryItem
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.databinding.DetailFragmentBinding
import com.example.mvvmcleanarch.extensions.loadImage
import com.example.mvvmcleanarch.view.base.BaseFragment

class DetailFragment : BaseFragment() {
    private lateinit var binding: DetailFragmentBinding
    private var repositoryItem: RepositoryItem? = null

    override fun getLayoutId() = R.layout.detail_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewsInitialized(binding: ViewBinding, view: View) {
        this.binding = binding as DetailFragmentBinding
        receiveArguments()
        setUpToolBar()
        initUi()
    }

    private fun initUi() {
        binding.tvStars.text = "Stars : ${repositoryItem?.stars ?: ""}"
        binding.tvForks.text = "Forks : ${repositoryItem?.forks ?: ""}"
        binding.tvLanguage.text = "Language : ${repositoryItem?.lang ?: ""}"
        binding.tvDescription.text = "Description : ${repositoryItem?.desc ?: ""}"
        binding.tvRepoLink.text = "Github Link : ${repositoryItem?.repoLink ?: ""}"
        binding.tvRepoName.text = repositoryItem?.repo ?: ""

        binding.ivAvatar.loadImage(context as MainActivity, repositoryItem?.avatars?.get(0))

    }

    private fun receiveArguments() {
        repositoryItem = arguments?.getParcelable("repositoryItem")
        Log.e("repo", repositoryItem.toString())
    }

    private fun setUpToolBar() {
        val toolbar = binding.tbDetail
        NavigationUI.setupWithNavController(toolbar, NavHostFragment.findNavController(this))
    }
}