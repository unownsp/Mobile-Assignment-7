package com.saugat.quizapp.ui.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.saugat.quizapp.R
import com.saugat.quizapp.databinding.RowResultBinding
import com.saugat.quizapp.pojo.Question
import com.saugat.quizapp.utils.DiffUtilCallbackImpl

class ResultAdapter(
    private val quizList: MutableList<Question> = mutableListOf()
) : RecyclerView.Adapter<ResultAdapter.ResultAnalysisViewHolder>() {

    inner class ResultAnalysisViewHolder(private val binding: RowResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(question: Question) {
            binding.que = question
        }
    }

    fun updateList(newList: List<Question>) {
        val result = DiffUtil.calculateDiff(DiffUtilCallbackImpl(quizList, newList))
        quizList.clear()
        quizList.addAll(newList)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultAnalysisViewHolder {
        val binding = RowResultBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.row_result, parent, false)
        )
        return ResultAnalysisViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultAnalysisViewHolder, position: Int) {
        holder.bind(quizList[position])
    }

    override fun getItemCount(): Int = quizList.size
}