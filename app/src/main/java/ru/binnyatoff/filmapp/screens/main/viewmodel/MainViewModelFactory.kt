package ru.binnyatoff.filmapp.screens.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.binnyatoff.filmapp.retrofit.RetrofitApi

class MainViewModelFactory(val retrofitApi: RetrofitApi):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == MainViewModel::class.java)
        return MainViewModel(retrofitApi = retrofitApi) as T
    }
}