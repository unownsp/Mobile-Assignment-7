package com.saugat.quizapp.repo

import com.saugat.quizapp.pojo.Question

interface QuizRepository {
    suspend fun insertQuestions(questions : MutableList<Question>)
    suspend fun insertQuestion(question: Question)
    suspend fun getQuestionList(): MutableList<Question>
    suspend fun resetQuestionSet()
}