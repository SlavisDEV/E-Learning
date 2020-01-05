package com.softroids.emptyproject.data

import com.softroids.emptyproject.data.model.Question

class QuizManager {

    val questions = listOf(
        Question(
            "Who was AC Milan's captain in the 2003-04 season?",
            hashMapOf(
                Pair(0, Pair("Alessandro Nesta", false)),
                Pair(1, Pair("Paolo Maldini", true)),
                Pair(2, Pair("Andriy Shevchenko", false)),
                Pair(3, Pair("Manuel Rui Costa", false))
            )
        ),
        Question(
            "Who was AC Milan's MOST surprising signing for the 2001-02 season?",
            hashMapOf(
                Pair(0, Pair("Filippo Inzaghi", true)),
                Pair(1, Pair("Manuel Rui Costa", false)),
                Pair(2, Pair("Javi Moreno", false)),
                Pair(3, Pair("Martin Laursen", false))
                )
        ),
        Question(
            "Was Gaetano Scirea, AC Milan's greatest defender of the 1990s?",
            hashMapOf(
                Pair(0, Pair("Yes", false)),
                Pair(1, Pair("No", true))
            )
        ),
        Question(
            "Which of the following was NOT signed by AC Milan for the 2003-04 season?",
            hashMapOf(
                Pair(0, Pair("Kaka", false)),
                Pair(1, Pair("Marcos Cafu", false)),
                Pair(2, Pair("Fabio Cannavaro", true)),
                Pair(3, Pair("Giuseppe Pancaro", false))
            )
        )
    )

    private var currentQuestion = -1

    val results = hashMapOf<Int, ArrayList<Int>>()

    fun getLeftQuestions() = questions.size - currentQuestion

    fun getNextQuestion(): Question? {
        currentQuestion++
        return if (currentQuestion >= questions.size) {
            currentQuestion = questions.size
            null
        } else {
            questions[currentQuestion]
        }
    }

    fun answerQuestion(question: Question, answerId: Int) {
        val questionId = questions.indexOf(question)
        when {
            results[questionId].isNullOrEmpty() -> {
                results[questionId] = arrayListOf(answerId)
            }
            results[questionId]!!.contains(answerId) -> {
                results[questionId]!!.remove(answerId)
            }
            else -> {
                results[questionId]!!.add(answerId)
            }
        }
    }

}