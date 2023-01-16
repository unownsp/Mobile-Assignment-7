package com.saugat.quizapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saugat.quizapp.pojo.Question
import com.saugat.quizapp.utils.Converter

@Database(
    entities = [Question::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class QuizDataBase: RoomDatabase() {
    abstract val quizDAO: QuizDAO
}