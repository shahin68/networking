package com.shahin.networking.data.sources

import com.shahin.networking.network.NetworkResponse
import com.google.gson.Gson
import retrofit2.Response
import java.lang.Exception

open class BaseRepository {
    inline fun <reified T : Any> networkResponseOf(service: () -> Response<T>): NetworkResponse<T> {
        return try {
            val response = service()
            if (response.isSuccessful) {
                NetworkResponse.Success(response.body()!!)
            } else {
                val gSon = Gson()
                val typedValue = gSon.fromJson(
                    response.errorBody()?.string(),
                    NetworkResponse.GenericError::class.java
                )
                NetworkResponse.GenericError(typedValue.errorModel)
            }
        } catch (e: Exception) {
            NetworkResponse.NetworkError
        }
    }
}