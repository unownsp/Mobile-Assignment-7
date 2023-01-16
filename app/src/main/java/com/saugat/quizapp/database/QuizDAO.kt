package com.saugat.quizapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saugat.quizapp.pojo.Question

@Dao
interface QuizDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuizQuestions(quizList : MutableList<Question>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuiz(quiz: Question)

    @Query("SELECT * FROM question")
    suspend fun getQuizList(): MutableList<Question>

    @Query("SELECT * FROM question WHERE id= :id")
    suspend fun getQuiz(id: Int): Question
}