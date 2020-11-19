package com.shahin.networking.di

import com.shahin.networking.data.sources.search.SearchRepository
import com.shahin.networking.data.sources.search.SearchRepositoryImp
import com.shahin.networking.data.sources.search.local.LocalDataSource
import com.shahin.networking.data.sources.search.local.LocalDataSourceImp
import com.shahin.networking.data.sources.search.remote.SearchRemoteDataSource
import com.shahin.networking.data.sources.search.remote.SearchRemoteDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class SearchModule {
    @Binds
    abstract fun bindSearchRemoteDataSource(
        searchRemoteDataSourceImp: SearchRemoteDataSourceImp
    ): SearchRemoteDataSource

    @Binds
    abstract fun bindSearchLocalDataSource(
        localDataSourceImp: LocalDataSourceImp
    ): LocalDataSource

    @Binds
    abstract fun bindSearchRepository(
        searchRepositoryImp: SearchRepositoryImp
    ): SearchRepository
}