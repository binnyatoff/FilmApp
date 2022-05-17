package ru.binnyatoff.filmapp.screens.main.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import ru.binnyatoff.filmapp.Films
import ru.binnyatoff.filmapp.R


class MainAdapter : PagingDataAdapter<Films, MainViewHolder>(MainDiffUtils) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.film_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val films = getItem(position)
        holder.bind(films)
        //Допилить развертывание окна фильма
        holder.itemView.setOnClickListener {
            notifyItemChanged(position)
        }
    }
}