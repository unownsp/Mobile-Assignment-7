package com.saugat.quizapp.repo

import com.saugat.quizapp.database.QuizDAO
import com.saugat.quizapp.database.QuizDataBase
import com.saugat.quizapp.pojo.Question
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val db: QuizDataBase
) : QuizRepository {

    private var quizDao: QuizDAO = db.quizDAO

    override suspend fun insertQuestions(questions: MutableList<Question>) {
        quizDao.insertQuizQuestions(questions)
    }

    override suspend fun insertQuestion(question: Question) {
        quizDao.insertQuiz(question)
    }

    override suspend fun getQuestionList(): MutableList<Question> {
        return quizDao.getQuizList()
    }

    override suspend fun resetQuestionSet() {
        db.clearAllTables()
    }

}