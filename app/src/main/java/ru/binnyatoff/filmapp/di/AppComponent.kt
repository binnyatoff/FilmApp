package ru.binnyatoff.filmapp.di

import dagger.Component
import ru.binnyatoff.filmapp.screens.main.MainActivity

@Component(modules = [DataModule::class, AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}