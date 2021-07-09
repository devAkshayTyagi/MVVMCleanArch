package com.example.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RepositoryItem(
    val repo: String?,
    @SerializedName("repo_link")
    val repoLink: String?,
    val desc: String?,
    val lang: String?,
    val stars: String?,
    val forks: String?,
    @SerializedName("added_stars")
    val addedStars: String?,
    val avatars: List<String>?
) : Parcelable