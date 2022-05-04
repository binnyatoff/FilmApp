package ru.binnyatoff.filmapp.screens.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.binnyatoff.filmapp.Constants
import ru.binnyatoff.filmapp.models.Films
import ru.binnyatoff.filmapp.models.Result
import ru.binnyatoff.filmapp.retrofit.RetrofitApi

class MainViewModel(val retrofitApi: RetrofitApi) : ViewModel() {

   val filmList = MutableLiveData<List<Films>>()

    init {
        getFilms()
    }

    fun getFilms() {
        viewModelScope.launch {
            try {
                val response = retrofitApi.getFilms(Constants.API_KEY)
                if (response.isSuccessful) {
                    val body = response.body()
                    val resultList = body?.results
                    parsing(resultList)
                } else {
                    Log.e("TAG", response.message())
                }
            } catch (e: Exception) {
                Log.e("TAG", "Error $e")
            }
        }
    }

    fun parsing(resultList: List<Result>?) {
        val myFilmList: MutableList<Films> = mutableListOf()

        resultList?.forEach {
            Log.e("TAG", it.toString())
            val myFilm = Films(
                filmName = it.display_title,
                filmDescription = it.summary_short,
                urlCover = it.multimedia.src,
            )
            myFilmList.add(myFilm)
        }
        myFilmList.forEach{
            Log.e("TAG", "$it")

        }
        filmList.postValue(myFilmList)
    }
}