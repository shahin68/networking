package com.shahin.networking.network

import com.google.gson.annotations.SerializedName
import com.shahin.networking.data.models.ErrorModel

sealed class NetworkResponse<out T> {
    data class Success<out T>(@SerializedName("data") val value: T): NetworkResponse<T>()
    data class GenericError(
        @SerializedName("error") val errorModel: ErrorModel
    ): NetworkResponse<Nothing>()
    object NetworkError: NetworkResponse<Nothing>()
}