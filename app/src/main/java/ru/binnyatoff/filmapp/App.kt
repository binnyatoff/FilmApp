package ru.binnyatoff.filmapp

import android.app.Application
import android.content.Context
import ru.binnyatoff.filmapp.di.AppComponent
import ru.binnyatoff.filmapp.di.DaggerAppComponent

class App:Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
       appComponent = DaggerAppComponent.builder().build()
    }
}
val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }