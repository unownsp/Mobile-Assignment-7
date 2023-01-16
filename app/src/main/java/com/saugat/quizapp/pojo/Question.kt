package com.saugat.quizapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey val id: Int,
    val question: String,
    val answerExplanation: String,
    val answer: String,
    val answerDesc: String,
    var userAnswer: String? = null,
    var userAnswerDesc: String? = null,
    var options: MutableList<String>
)