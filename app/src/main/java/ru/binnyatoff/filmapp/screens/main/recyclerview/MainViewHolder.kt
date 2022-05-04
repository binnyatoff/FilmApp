package ru.binnyatoff.filmapp.screens.main.recyclerview

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.binnyatoff.filmapp.databinding.FilmItemBinding
import ru.binnyatoff.filmapp.models.Films
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import ru.binnyatoff.filmapp.R

class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val viewBinding: FilmItemBinding by viewBinding()

    fun bind(currentFilm: Films) {
        with(viewBinding){
            filmName.text = currentFilm.filmName
            filmDescription.text = currentFilm.filmDescription
            //filmDescription.text = filmDescription.text.toString() + currentFilm.filmDescription
        }

        getImage(currentFilm.urlCover)
    }


    private fun getImage(url: String) {
        Glide
            .with(view.context)
            .load(url)
            //.circleCrop()
            .into(viewBinding.filmCover)
    }
}