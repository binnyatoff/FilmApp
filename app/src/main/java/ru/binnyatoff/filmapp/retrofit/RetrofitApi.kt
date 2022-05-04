package ru.binnyatoff.filmapp.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.binnyatoff.filmapp.models.Film

interface RetrofitApi {
    @GET("svc/movies/v2/reviews/all.json")
    suspend fun getFilms(@Query("api-key") sort: String): Response<Film>

}