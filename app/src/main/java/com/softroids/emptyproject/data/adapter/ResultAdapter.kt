package com.softroids.emptyproject.data.adapter

import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softroids.emptyproject.R
import com.softroids.emptyproject.data.model.Question

class ResultAdapter(
    private val questions: List<Question>,
    private val results: HashMap<Int, ArrayList<Int>>,
    private val context: Context
) : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false))
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = questions[position]
        val answerAdapter = AnswerAdapter(question.answers, context, results[position]) {}

        holder.apply {
            this.question.text = question.question
            this.answers.apply {
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                adapter = answerAdapter
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val question: TextView = view.findViewById(R.id.textView_question)
        val answers: RecyclerView = view.findViewById(R.id.recyclerView_answers_result)
    }
}