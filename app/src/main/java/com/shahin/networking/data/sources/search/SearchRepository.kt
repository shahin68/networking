package com.shahin.networking.data.sources.search

import com.shahin.networking.data.models.SearchResponse
import com.shahin.networking.network.NetworkResponse

interface SearchRepository {
    suspend fun search(
        string: String
    ): NetworkResponse<List<SearchResponse>>
}