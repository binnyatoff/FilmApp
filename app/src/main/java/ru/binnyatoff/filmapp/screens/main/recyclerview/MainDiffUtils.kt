package ru.binnyatoff.filmapp.screens.main.recyclerview

import androidx.recyclerview.widget.DiffUtil
import ru.binnyatoff.filmapp.models.Films

object MainDiffUtils : DiffUtil.ItemCallback<Films>() {
    override fun areItemsTheSame(oldItem: Films, newItem: Films): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Films, newItem: Films): Boolean {
        return  oldItem.display_title == newItem.display_title
    }
}