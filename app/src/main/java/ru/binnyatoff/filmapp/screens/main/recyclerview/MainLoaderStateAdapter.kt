package ru.binnyatoff.filmapp.screens.main.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.binnyatoff.filmapp.R
import ru.binnyatoff.filmapp.databinding.ErrorBinding

class MainLoaderStateAdapter : LoadStateAdapter<MainLoaderStateAdapter.LoaderViewHolder>() {


    override fun onBindViewHolder(holder: LoaderViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoaderViewHolder {
        return when (loadState) {
            LoadState.Loading -> ProgressViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.progress, parent, false)
            )
            is LoadState.NotLoading -> NotLoading(
                LayoutInflater.from(parent.context).inflate(R.layout.error, parent, false)
            )
            is LoadState.Error -> ErrorViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.error, parent, false)
            )
        }
    }

    abstract class LoaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(loadState: LoadState)
    }

    class NotLoading(view: View) : LoaderViewHolder(view) {
        private val viewBinding: ErrorBinding by viewBinding()
        override fun bind(loadState: LoadState) {
            viewBinding.errorMessage.visibility = View.GONE
        }
    }

    class ProgressViewHolder(view: View) : LoaderViewHolder(view) {
        override fun bind(loadState: LoadState) {
            //Nothing
        }
    }

    class ErrorViewHolder(view: View) : LoaderViewHolder(view) {
        private val viewBinding: ErrorBinding by viewBinding()
        override fun bind(loadState: LoadState) {
            require(loadState is LoadState.Error)
            viewBinding.errorMessage.text = loadState.error.toString()
        }
    }
}

