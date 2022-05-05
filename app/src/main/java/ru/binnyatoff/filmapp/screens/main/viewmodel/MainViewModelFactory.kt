package ru.binnyatoff.filmapp.screens.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.binnyatoff.filmapp.data.network.FilmService
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val filmService: FilmService):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == MainViewModel::class.java)
        return MainViewModel(filmService) as T
    }
}