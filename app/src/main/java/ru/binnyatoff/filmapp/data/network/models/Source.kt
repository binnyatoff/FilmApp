package ru.binnyatoff.filmapp.data.network.models

data class Source(
    val copyright: String,
    val has_more: Boolean,
    val num_results: Int,
    val results: List<Results>,
    val status: String
)
