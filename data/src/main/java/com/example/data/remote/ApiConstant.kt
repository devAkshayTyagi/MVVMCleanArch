package com.example.data.remote

class ApiConstant {

    companion object {
        /*********API BASE URL************/
        const val BASE_URL = "https://trendings.herokuapp.com/"

        const val LANGUAGE = "lang"
        const val TIME = "since"
        const val WEEKLY = "weekly"
        const val JAVA = "java"
        const val LISTING_FRAGMENT = "ListingFragment"
        const val API_GET_TRENDING_REPOSITORIES = "repo?$LANGUAGE=$JAVA&$TIME=$WEEKLY"
    }

}