package ru.binnyatoff.filmapp.di

import dagger.Module
import dagger.Provides
import ru.binnyatoff.filmapp.retrofit.RetrofitApi
import ru.binnyatoff.filmapp.screens.main.viewmodel.MainViewModelFactory
import ru.binnyatoff.filmapp.screens.main.recyclerview.MainAdapter

@Module
class AppModule {

    @Provides
    fun provideMainViewModelFactory(retrofitApi: RetrofitApi): MainViewModelFactory {
        return MainViewModelFactory(retrofitApi)
    }

    @Provides
    fun povideMainAdapter(): MainAdapter {
        return MainAdapter()
    }
}