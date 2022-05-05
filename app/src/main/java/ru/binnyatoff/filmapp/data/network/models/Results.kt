package ru.binnyatoff.filmapp.data.network.models

data class Results(
    val byline: String,
    val critics_pick: Int,
    val date_updated: String,
    val display_title: String,//Name of Film
    val headline: String,
    val link: Link,
    val mpaa_rating: String,
    val multimedia: Multimedia,
    val opening_date: Any,
    val publication_date: String,
    val summary_short: String,
    val expanden: Boolean = false//main future
)


