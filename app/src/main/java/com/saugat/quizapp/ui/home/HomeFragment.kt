package com.saugat.quizapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.saugat.quizapp.SplashActivity
import com.saugat.quizapp.databinding.FragmentHomeBinding
import com.saugat.quizapp.utils.ApplicationData
import com.saugat.quizapp.viewmodel.QuestionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _homeBinding: FragmentHomeBinding? = null
    private val binding get() = _homeBinding!!

    private lateinit var viewModel: QuestionViewModel

    private var questionNumber: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[QuestionViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        binding.questionNumber.text = "1"

        viewModel.data.observe(viewLifecycleOwner) { quizList ->
            quizList?.let {
                val viewPagerAdapter = ViewPagerAdapter(this, it.shuffled())
                binding.viewPager.adapter = viewPagerAdapter
            }
        }

        binding.nextButton.setOnClickListener {
            binding.viewPager.setCurrentItem(binding.viewPager.currentItem + 1, true)

            binding.questionNumber.text = "" + (binding.viewPager.currentItem + 1)
            //Result Fragment
            if (binding.viewPager.currentItem == 15) {
                binding.buttonsLL.visibility = View.GONE
                binding.viewPager.isUserInputEnabled = false
            }
        }

        binding.homeButton.setOnClickListener {
            viewModel.resetDatabase(ApplicationData.getQuizQuestions())
            val intent = Intent(activity, SplashActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}