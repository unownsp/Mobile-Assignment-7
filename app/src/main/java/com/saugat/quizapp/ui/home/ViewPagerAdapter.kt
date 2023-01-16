package com.saugat.quizapp.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.gson.Gson
import com.saugat.quizapp.pojo.Question
import com.saugat.quizapp.ui.question.QuestionFragment
import com.saugat.quizapp.ui.result.ResultFragment

class ViewPagerAdapter(
    fragment: Fragment,
    private val questionList: List<Question>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = questionList.size + 1

    override fun createFragment(position: Int): Fragment {
        val fragment: Fragment = if (position == 15) {
            ResultFragment.newInstance()
        } else {
            val quiz = questionList[position]
            QuestionFragment.newInstance(Gson().toJson(quiz))
        }

        return fragment
    }

}