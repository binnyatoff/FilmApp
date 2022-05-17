package ru.binnyatoff.filmapp

import ru.binnyatoff.filmapp.data.network.models.Results

fun Results.toFilms(): Films{
    return Films(
        film_name = this.display_title,
        film_description = this.summary_short,
        cover_url = this.multimedia.src,
        expanded = false
    )
}