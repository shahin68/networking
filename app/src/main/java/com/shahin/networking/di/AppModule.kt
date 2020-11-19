package com.shahin.networking.di

import com.shahin.networking.data.sources.search.remote.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    fun provideSearchApi(
        retrofit: Retrofit
    ): Api {
        return retrofit.create(Api::class.java)
    }


}