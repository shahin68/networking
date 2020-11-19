package com.shahin.networking.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shahin.networking.data.models.SearchResponse
import com.shahin.networking.data.sources.search.SearchRepository
import com.shahin.networking.network.NetworkResponse
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val searchRepository: SearchRepository
): ViewModel() {

    private val _searchResults: MutableLiveData<List<SearchResponse>> = MutableLiveData()
    val searchResults: LiveData<List<SearchResponse>> = _searchResults

    private val _searchError = MutableLiveData<String>()
    val searchError: LiveData<String> = _searchError

    fun search(string: String) {
        viewModelScope.launch {
            when (val response = searchRepository.search(string)) {
                is NetworkResponse.Success -> _searchResults.postValue(response.value)
                is NetworkResponse.GenericError -> _searchError.postValue(response.errorModel.message)
                is NetworkResponse.NetworkError -> _searchError.postValue("No Network")
            }
        }
    }

}