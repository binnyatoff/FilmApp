package ru.binnyatoff.filmapp.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.binnyatoff.filmapp.models.AllFilmResponse

interface FilmService {
    @GET("svc/movies/v2/reviews/all.json")
    suspend fun getFilms(
        @Query("api-key") api_key: String,
        @Query("offset") offset: Int = 0
    ): Response<AllFilmResponse>
}