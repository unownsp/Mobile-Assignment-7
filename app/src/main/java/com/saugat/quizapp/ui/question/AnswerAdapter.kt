package com.saugat.quizapp.ui.question

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.saugat.quizapp.R
import com.saugat.quizapp.utils.RadioClickInterface

class AnswerAdapter(
    private val answers: MutableList<String> = mutableListOf(),
    private val listener: RadioClickInterface
) : RecyclerView.Adapter<AnswerAdapter.RBQuestionViewHolder>(){

    var selectedPosition = -1

    inner class RBQuestionViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val optionRB: RadioButton = view.findViewById(R.id.optionRB)
        fun bind(option: String) {
            optionRB.text = option
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RBQuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_answer, parent, false)
        return RBQuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RBQuestionViewHolder, position: Int) {
        holder.bind(answers[position])

        //to achieve radio behaviour these operations are performed(only one option can select)
        holder.optionRB.isChecked = position == selectedPosition;
        holder.optionRB.setOnClickListener {
            selectedPosition=  position
            notifyDataSetChanged()
            listener.onRadioButtonClicked(position, holder.optionRB.text.toString())
        }
    }

    override fun getItemCount(): Int = answers.size
}