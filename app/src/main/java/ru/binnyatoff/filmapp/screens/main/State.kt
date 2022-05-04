package ru.binnyatoff.filmapp.screens.main

sealed class State {
    class Loaded: State()
    class Loading: State()
    class Error: State()
    class Empty: State()
}