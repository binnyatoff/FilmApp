package ru.binnyatoff.filmapp.screens.main.recyclerview

import androidx.recyclerview.widget.DiffUtil
import ru.binnyatoff.filmapp.models.Films

class MainDiffUtils(private val oldList:List<Films>, private val newList:List<Films>):DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].filmName == newList[newItemPosition].filmName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}