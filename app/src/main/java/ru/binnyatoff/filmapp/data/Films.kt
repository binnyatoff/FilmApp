package ru.binnyatoff.filmapp

data class Films(
    val film_name:String,
    val film_description:String,
    val cover_url:String,
    var expanded:Boolean
)
