package com.example.data.repository

import com.example.data.remote.ApiServices
import com.example.domain.model.RepositoryItem
import com.example.domain.model.TrendingRepositoryResponse
import com.example.domain.repository.MainRepository
import io.reactivex.Single

class MainRepositoryImpl constructor(val apiService: ApiServices) : MainRepository {

    override fun getTrendingRepository(): Single<List<RepositoryItem>> {
        return apiService.getTrendingRepos().map {
            it.toDomainModel()
        }
    }

}

private fun TrendingRepositoryResponse.toDomainModel(): List<RepositoryItem> {
    val result: List<RepositoryItem>? = items?.map {
        RepositoryItem(
            it.repo,
            it.repoLink,
            it.desc,
            it.lang,
            it.stars,
            it.forks,
            it.addedStars,
            it.avatars
        )
    }

    return result ?: listOf()
}