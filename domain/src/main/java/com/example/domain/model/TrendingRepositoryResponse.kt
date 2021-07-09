package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrendingRepositoryResponse(
    val count: Int?,
    val msg: String?,
    val items: List<RepositoryItem>?
) : Parcelable