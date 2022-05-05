package ru.binnyatoff.filmapp.di

import dagger.Module
import dagger.Provides
import ru.binnyatoff.filmapp.retrofit.FilmService
import ru.binnyatoff.filmapp.screens.main.viewmodel.MainViewModelFactory
import ru.binnyatoff.filmapp.screens.main.recyclerview.MainAdapter

@Module
class AppModule {

    @Provides
    fun provideMainViewModelFactory(filmService: FilmService): MainViewModelFactory {
        return MainViewModelFactory(filmService)
    }

    @Provides
    fun provideMainAdapter(): MainAdapter {
        return MainAdapter()
    }
}