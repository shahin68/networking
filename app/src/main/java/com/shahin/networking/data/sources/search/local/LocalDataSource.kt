package com.shahin.networking.data.sources.search.local

interface LocalDataSource {
    fun getApiKey(): String
    fun getSearchControlPanel(): String
}