package com.hofstedematheus.hetorde.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hofstedematheus.hetorde.data.repository.DutchArticleRepository
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

class MainViewModel(private val repository: DutchArticleRepository) : ViewModel(), KoinComponent {

    val dataState = MutableLiveData(DataState.DATA_IDLE)
    val noun = MutableLiveData<String>()

    fun getArticle(word: String) {
        dataState.value = DataState.DATA_LOADING
        viewModelScope.launch {
            with(repository.getArticle(word)) {
                noun.postValue(this)
                dataState.postValue(DataState.DATA_LOADED)
            }
        }

    }

}

enum class DataState {
    DATA_LOADING, DATA_ERROR, DATA_LOADED, DATA_IDLE
}