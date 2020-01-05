package com.softroids.emptyproject.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.softroids.emptyproject.R
import kotlinx.android.synthetic.main.item_answer.view.*

class AnswerAdapter(
    private val answers: HashMap<Int, Pair<String, Boolean>>,
    private val context: Context,
    private val onClicked: (Int) -> Unit
) : RecyclerView.Adapter<AnswerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_answer, parent, false))
    }

    override fun getItemCount(): Int {
        return answers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val answer = answers[position]!!

        holder.apply {
            this.answer.text = answer.first
            itemView.setOnClickListener {
                onClicked(position)
                if (!answers[position]!!.second) {
                    indicator.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.background
                        )
                    )
                    answers.remove(position)
                    answers[position] = Pair(answer.first, true)
                }
                else {
                    indicator.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.background_lighter
                        )
                    )
                    answers.remove(position)
                    answers[position] = Pair(answer.first, false)
                }
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val answer: TextView = view.findViewById(R.id.textView_answer)
        val indicator: View = view.findViewById(R.id.divider)
    }
}