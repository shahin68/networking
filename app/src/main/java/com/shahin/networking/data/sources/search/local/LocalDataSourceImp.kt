package com.shahin.networking.data.sources.search.local

import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(): LocalDataSource {
    override fun getApiKey(): String {
        return "AIzaSyBDpBAz9F1TNhu9lJ8cwxprEQXs7Fbtqqw"
    }

    override fun getSearchControlPanel(): String {
        return "017576662512468239146:omuauf_lfve"
    }

}