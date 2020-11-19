package com.shahin.networking.data.sources.search.remote

import com.shahin.networking.data.models.SearchResponse
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @GET("customsearch/v1")
    suspend fun query(
        @Query("key") apiKey: String,
        @Query("cx") cxEngine: String,
        @Query("q") query: String
    ): Response<List<SearchResponse>>

}