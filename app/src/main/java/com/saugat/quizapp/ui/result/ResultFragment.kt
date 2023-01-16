package com.saugat.quizapp.ui.result

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.saugat.quizapp.R
import com.saugat.quizapp.SplashActivity
import com.saugat.quizapp.databinding.FragmentResultBinding
import com.saugat.quizapp.utils.ApplicationData
import com.saugat.quizapp.viewmodel.AnswerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {
    private var dataSize: Int = 0
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: AnswerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[AnswerViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.data.observe(viewLifecycleOwner) { quizList ->
            quizList?.let {
                var totalScore = 0
                dataSize = it.size
                it.forEach { quiz ->
                    Log.v("ResultFragment", quiz.userAnswer.toString())
                    if (quiz.answer == quiz.userAnswer) {
                        totalScore++
                    }
                }
                setUpUI(totalScore)
            }
        }

        binding.tryAgainButton.setOnClickListener {
            viewModel.resetDatabase(ApplicationData.getQuizQuestions())
            val intent = Intent(activity, SplashActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        binding.resultAnalysisButton.setOnClickListener {
            val intent = Intent(activity, ResultActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setUpUI(totalScore: Int) {
        binding.totalQuestionsTv.text = "${getString(R.string.total_questions)} $dataSize"
        binding.correctAnswerTv.text = "${getString(R.string.correct_answers)} $totalScore"
        binding.wrongAnswerTv.text =
            getString(R.string.wrong_answer) + " " + (dataSize - totalScore)
        binding.yourScoreTv.text =
            getString(R.string.your_score) + " " + totalScore + " / " + dataSize

    }

    companion object {
        @JvmStatic
        fun newInstance() = ResultFragment()
    }
}