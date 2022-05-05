package ru.binnyatoff.filmapp.models

data class AllFilmResponse(
    val copyright: String,
    val has_more: Boolean,
    val num_results: Int,
    val results: List<Films>,
    val status: String
)
