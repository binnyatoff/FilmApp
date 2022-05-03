package ru.binnyatoff.filmapp.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.calculateDiff
import androidx.recyclerview.widget.RecyclerView
import ru.binnyatoff.filmapp.R
import ru.binnyatoff.filmapp.models.Films

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    private var filmList = emptyList<Films>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.film_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentFilm = filmList[position]
        holder.bind(currentFilm)
    }

    override fun getItemCount() = filmList.size

    fun setData(newfilmList: List<Films>){
        val diffCallback = MainDiffUtils(filmList, newfilmList)
        val diffResult = calculateDiff(diffCallback)
        filmList = newfilmList
        diffResult.dispatchUpdatesTo(this)
    }
}