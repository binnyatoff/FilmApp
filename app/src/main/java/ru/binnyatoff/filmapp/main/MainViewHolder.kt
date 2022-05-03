package ru.binnyatoff.filmapp.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.binnyatoff.filmapp.databinding.FilmItemBinding
import ru.binnyatoff.filmapp.models.Films
import by.kirich1409.viewbindingdelegate.viewBinding

class MainViewHolder(view :View):RecyclerView.ViewHolder(view) {
    private val viewBinding: FilmItemBinding by viewBinding()

    fun bind(currentFilm: Films) {
        with(viewBinding){
            filmName.text = currentFilm.filmName
            getImage(currentFilm.urlCover)
        }

    }

    private fun getImage(url: String) {
        /*Glide
            .with(context)
            .load(url)
            .circleCrop()
            .into(viewBinding.filmCover)*/
    }
}