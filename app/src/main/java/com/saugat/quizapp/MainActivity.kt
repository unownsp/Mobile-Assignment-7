package com.saugat.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.saugat.quizapp.database.QuizDB
import com.saugat.quizapp.databinding.ActivityMainBinding
import com.saugat.quizapp.utils.ApplicationData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val questions = ApplicationData.getQuizQuestions()
        val quizDAO = QuizDB(this).getQuizDAO()

        MainScope().launch(Dispatchers.IO) {
            quizDAO.insertQuizQuestions(questions)
        }
    }
}