package com.shahin.networking.data.sources.search.remote

import com.shahin.networking.data.models.SearchResponse
import com.shahin.networking.network.NetworkResponse

interface SearchRemoteDataSource {
    suspend fun search(string: String): NetworkResponse<List<SearchResponse>>
}