package com.example.data.remote

import com.example.domain.model.TrendingRepositoryResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiServices {

    @GET(ApiConstant.API_GET_TRENDING_REPOSITORIES)
    fun getTrendingRepos(): Single<TrendingRepositoryResponse>

}