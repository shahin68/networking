package com.shahin.networking.data.sources.search

import com.shahin.networking.data.models.SearchResponse
import com.shahin.networking.data.sources.search.local.LocalDataSource
import com.shahin.networking.data.sources.search.remote.SearchRemoteDataSource
import com.shahin.networking.network.NetworkResponse
import javax.inject.Inject

class SearchRepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val searchRemoteDataSource: SearchRemoteDataSource
): SearchRepository {
    override suspend fun search(string: String): NetworkResponse<List<SearchResponse>> {
        return searchRemoteDataSource.search(string)
    }

}