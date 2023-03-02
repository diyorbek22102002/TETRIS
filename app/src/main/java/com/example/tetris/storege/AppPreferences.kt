package com.example.tetris.storege
import android.content.Context
import android.content.SharedPreferences
//     База данных getSharedPreferences()
class AppPreferences (ctx: Context){

    //    Класс Context поддерживает доступ к методу getSharedPreferences()
    var data : SharedPreferences = ctx.getSharedPreferences("APP_PREFERENCES",Context.MODE_PRIVATE)

    /* Функция saveHighScore() принимает целое число — наибольшее количество очков, которое будет сохраняться,
    когда единственный аргумент data.edit()*/
    fun saveHighScore(highScore : Int){
      data.edit().putInt("HIGH_SCORE",highScore).apply()
    }

    /*Функция getHighScore() возвращает наибольшее количество очков при вызове
    данных с помощью функции getInt().*/
    fun getHighScore() : Int{
        return data.getInt("HIGH_SCORE",0)
    }
    /*Функция clearHighScore() сбрасывает значение наибольшего количества очков до
     нуля, просто перезаписывая нулем значение, соответствующее ключу HIGH_SCORE.*/
    fun clearHighScore(){
        data.edit().putInt("HIGH_SCORE",0).apply()
    }
    /**
     * Идентификатор --"HIGH_SCORE"-- является уникальным идентификатором значения, которое необходимо получить. Значение 0, передаваемое
    второму аргументу функции, указывает заданное по умолчанию значение,
    котороедолжно возвращаться сценарием, если в сценарии отсутствует соответствующее
    указанному ключу значение.
     */

}

