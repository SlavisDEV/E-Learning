package com.softroids.emptyproject.ui.test

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.softroids.emptyproject.R
import com.softroids.emptyproject.data.QuizManager
import com.softroids.emptyproject.data.model.Question
import com.softroids.emptyproject.settings.AppSettings
import javax.inject.Inject

class TestActivityViewModel @Inject constructor() {

    @Inject
    protected lateinit var viewAccess: TestActivityViewAccess

    @Inject
    protected lateinit var quizManager: QuizManager

    @Inject
    protected lateinit var context: Context

    @Inject
    protected lateinit var appSettings: AppSettings

    private var currentQuestion: Question? = null

    private val _question = MutableLiveData<String>()
    val question: LiveData<String>
        get() = _question

    private val _leftQuestionNumber = MutableLiveData<String>()
    val leftQuestionNumber: LiveData<String>
        get() = _leftQuestionNumber

    fun setup() {
        currentQuestion = quizManager.getNextQuestion()
        _leftQuestionNumber.value = context.getString(R.string.leftQuestions, quizManager.getLeftQuestions())
        if (quizManager.getLeftQuestions() == 1) {
            viewAccess.changeFloatActionIcon()
        }
        if (currentQuestion == null) {
            appSettings.saveAnswers(quizManager.results)
            viewAccess.finishQuiz()
        } else {
            _question.value = currentQuestion!!.question
            val answers = currentQuestion!!.answers
            val answersToLoad = hashMapOf<Int, Pair<String, Boolean>>()
            answers.forEach { (id, answer) ->
                answersToLoad[id] = Pair(answer.first, false)
            }
            viewAccess.initAnswers(answersToLoad)
        }
    }

    fun selectAnswer(answerId: Int) {
        quizManager.answerQuestion(currentQuestion!!, answerId)
    }

    fun loadNextQuestion() {
        setup()
    }
}