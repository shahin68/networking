package com.shahin.networking.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class SearchResponse(
    @SerializedName("kind") val kind: String,
    @SerializedName("title") val title: String,
    @SerializedName("htmlTitle") val htmlTitle: String,
    @SerializedName("link") val link: String,
    @SerializedName("displayLink") val displayLink: String,
    @SerializedName("snippet") val snippet: String,
    @SerializedName("htmlSnippet") val htmlSnippet: String,
    @SerializedName("cacheId") val cacheId: String,
    @SerializedName("formattedUrl") val formattedUrl: String,
    @SerializedName("htmlFormattedUrl") val htmlFormattedUrl: String,
)