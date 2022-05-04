package ru.binnyatoff.filmapp.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.binnyatoff.filmapp.screens.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG", "Splash")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}