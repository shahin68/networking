package com.shahin.networking.data.sources.search.remote

import com.shahin.networking.data.models.SearchResponse
import com.shahin.networking.data.sources.BaseRepository
import com.shahin.networking.data.sources.search.local.LocalDataSource
import com.shahin.networking.network.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchRemoteDataSourceImp @Inject constructor(
    private val api: Api,
    private val localDataSource: LocalDataSource
): BaseRepository(), SearchRemoteDataSource {
    override suspend fun search(string: String): NetworkResponse<List<SearchResponse>> {
        return withContext(Dispatchers.IO) {
            return@withContext networkResponseOf {
                api.query(
                    localDataSource.getApiKey(),
                    localDataSource.getSearchControlPanel(),
                    string
                )
            }
        }
    }
}