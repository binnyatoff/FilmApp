package ru.binnyatoff.filmapp.screens.main.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.binnyatoff.filmapp.databinding.FilmItemBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import ru.binnyatoff.filmapp.Films

open class MainViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val viewBinding: FilmItemBinding by viewBinding()

    fun bind(currentFilm: Films?) {
        if (currentFilm != null){
            with(viewBinding){
                filmName.text = currentFilm.film_name
                filmDescription.text = currentFilm.film_description
            }
            getImage(currentFilm.cover_url)
        }
    }


    private fun getImage(url: String) {
        Glide
            .with(view.context)
            .load(url)
            .into(viewBinding.filmCover)
    }
}