package ru.binnyatoff.filmapp.models

data class Film(
    val copyright: String,
    val has_more: Boolean,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)
