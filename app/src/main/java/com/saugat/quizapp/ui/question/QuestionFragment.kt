package com.saugat.quizapp.ui.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.saugat.quizapp.databinding.FragmentQuestionBinding
import com.saugat.quizapp.pojo.Question
import com.saugat.quizapp.utils.RadioClickInterface
import com.saugat.quizapp.viewmodel.QuestionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionFragment : Fragment(), RadioClickInterface {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!

    lateinit var question: Question
    lateinit var viewModel: QuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[QuestionViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        init()
    }

    private fun getData() {
        arguments?.let {
            question = Gson().fromJson(it.getString("question"), Question::class.java)
        }
    }

    private fun init() {
        binding.questionTextView.text = question.question

        val adapter = AnswerAdapter(question.options, this)
        binding.optionsRecyclerView.adapter = adapter
    }

    companion object {

        @JvmStatic
        fun newInstance(question: String) =
            QuestionFragment().apply {
                arguments = Bundle().apply {
                    putString("question", question)
                }
            }
    }

    override fun onRadioButtonClicked(optionPosition: Int, userAnswerDesc: String) {
        question.userAnswer = when (optionPosition) {
            0 -> "a"
            1 -> "b"
            2 -> "c"
            3 -> "d"
            else -> ""
        }
        question.userAnswerDesc = userAnswerDesc
        viewModel.saveUserAnswer(question)
    }
}