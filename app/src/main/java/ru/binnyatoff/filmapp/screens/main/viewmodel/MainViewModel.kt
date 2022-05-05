package ru.binnyatoff.filmapp.screens.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import ru.binnyatoff.filmapp.data.network.FilmService
import ru.binnyatoff.filmapp.data.network.FilmsPageSource

class MainViewModel(private val filmService: FilmService) : ViewModel() {

    val filmList = Pager(
        PagingConfig(pageSize = 20)
    ) {
        FilmsPageSource(filmService)
    }.flow
        .cachedIn(viewModelScope)
}

