package ru.binnyatoff.filmapp.screens.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.binnyatoff.filmapp.databinding.ActivityMainBinding
import ru.binnyatoff.filmapp.R
import ru.binnyatoff.filmapp.appComponent
import ru.binnyatoff.filmapp.screens.main.recyclerview.MainAdapter
import javax.inject.Inject
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.binnyatoff.filmapp.screens.main.viewmodel.MainViewModel
import ru.binnyatoff.filmapp.screens.main.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    @Inject
    lateinit var mainAdapter: MainAdapter

    private val viewBinding: ActivityMainBinding by viewBinding()
    private val viewModel by viewModels<MainViewModel> {
        mainViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("TAG", "MainActivity")
        this.appComponent.inject(this)

        viewBinding.filmRecyclerView.adapter = mainAdapter
        viewBinding.filmRecyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.filmList.observe(this){
            mainAdapter.setData(it)
        }
    }
}
