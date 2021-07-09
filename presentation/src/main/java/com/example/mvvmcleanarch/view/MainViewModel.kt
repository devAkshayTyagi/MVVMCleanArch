package com.example.mvvmcleanarch.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.RepositoryItem
import com.example.domain.usecase.FetchTrendingRepositoryUseCase
import io.reactivex.observers.DisposableSingleObserver

class MainViewModel constructor(
    val fetchTrendingRepositoryUseCase: FetchTrendingRepositoryUseCase
) : ViewModel() {

    val repositoryListLiveData = MutableLiveData<List<RepositoryItem>>()

    init{
        fetchTrendingRepositories()
    }

    fun fetchTrendingRepositories() {
        fetchTrendingRepositoryUseCase.execute(object :
            DisposableSingleObserver<List<RepositoryItem>>() {
            override fun onSuccess(response: List<RepositoryItem>) {
                repositoryListLiveData.value = response
            }
            override fun onError(e: Throwable) {
                Log.e("MainViewModel", "Error: ${e.message}")
            }
        })
    }
}
