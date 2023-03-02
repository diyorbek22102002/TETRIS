package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.tetris.domain.Frame
import com.example.tetris.storege.AppPreferences
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    var tvHighScore : TextView ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // скрывает панель приложения.
        supportActionBar?.hide()


        // -------------------------------------------------

        val btNowGame = findViewById<Button>(R.id.btr_now_game)
        val resetScore = findViewById<Button>(R.id.btr_reset_score)
        val exit = findViewById<Button>(R.id.btr_exit)
        tvHighScore = findViewById<TextView>(R.id.tv_high_score)
        // 1
        btNowGame.setOnClickListener(this::onBtnNewGameClick)

        // 2
        exit.setOnClickListener(this::onBtnExitClick)

        // 3
        resetScore.setOnClickListener(this::onBtnResetScore)

    }
    // 1 : Функция для перемишение на другой экран
    private fun onBtnNewGameClick (view: View) {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
    // 2 : Функция выход из приложения
    private fun onBtnExitClick(view: View){
        exitProcess(0)
    }
    // 3 : Функция для сброс сщёчика
    private fun onBtnResetScore(view: View) {
        val preferences = AppPreferences(this)
        preferences.clearHighScore()
//        дизайн android SnackBar
        Snackbar.make(view,"Оценка успешно сброшена",Snackbar.LENGTH_SHORT).show()

        val highScore = "Высокий балл : ${preferences.getHighScore()}"
        tvHighScore?.text = highScore
        println(tvHighScore?.text)
    }
}