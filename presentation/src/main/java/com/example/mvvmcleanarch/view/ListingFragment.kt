package com.example.mvvmcleanarch.view

import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.data.remote.ApiConstant
import com.example.domain.model.RepositoryItem
import com.example.mvvmcleanarch.MainApplication
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.databinding.FragmentListingBinding
import com.example.mvvmcleanarch.view.base.BaseFragment
import javax.inject.Inject
import javax.inject.Named

class ListingFragment : BaseFragment() {
    @Inject
    @Named(ApiConstant.LISTING_FRAGMENT)
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentListingBinding
    private lateinit var adapterTrendingRepoList: AdapterTrendingRepoList
    private var arrTrending = ArrayList<RepositoryItem>()

    override fun getLayoutId() = R.layout.fragment_listing

    override fun onViewsInitialized(binding: ViewBinding, view: View) {
        (activity?.applicationContext as MainApplication).component.inject(this)
        this.binding = binding as FragmentListingBinding
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.repositoryListLiveData.observe(this, {
            arrTrending = it as ArrayList<RepositoryItem>
            Log.e("List", arrTrending.size.toString())
            initAdapter()
        })


    }

    /** Method to initialize adapter*/
    private fun initAdapter() {
        adapterTrendingRepoList =
            AdapterTrendingRepoList(
                arrTrending,
                this::onItemSelected
            )
        val layoutManager =
            LinearLayoutManager((context as MainActivity))
        binding.rvTrendingRepo.layoutManager = layoutManager
        binding.rvTrendingRepo.adapter = adapterTrendingRepoList
    }


    /** Higher order function */
    private fun onItemSelected(repositoryItem: RepositoryItem) {

        val bundle = bundleOf("repositoryItem" to repositoryItem)
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.detailFragment, bundle)
    }


}