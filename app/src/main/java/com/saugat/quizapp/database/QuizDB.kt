package com.saugat.quizapp.database

import android.content.Context
import androidx.room.Room
import com.saugat.quizapp.utils.Constant

class QuizDB(context: Context) {

    private var quizDatabase: QuizDataBase = Room.databaseBuilder(
        context,
        QuizDataBase::class.java,
        Constant.DB_NAME
    ).build()

    fun getQuizDAO(): QuizDAO = quizDatabase.quizDAO
}