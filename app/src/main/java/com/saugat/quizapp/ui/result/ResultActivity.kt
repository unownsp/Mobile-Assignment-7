package com.saugat.quizapp.ui.result

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.saugat.quizapp.databinding.ActivityResultBinding
import com.saugat.quizapp.viewmodel.QuestionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    private val viewModel: QuestionViewModel by viewModels()
    private lateinit var adapter: ResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ResultAdapter()
        binding.resultAnalysisRecyclerView.adapter = adapter

        viewModel.data.observe(this) {
            it?.let {
                adapter.updateList(it)
            }
        }
    }
}