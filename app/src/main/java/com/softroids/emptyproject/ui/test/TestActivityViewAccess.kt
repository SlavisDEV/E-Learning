package com.softroids.emptyproject.ui.test

interface TestActivityViewAccess {

    fun initAnswers(answers: HashMap<Int, Pair<String, Boolean>>)
    fun finishQuiz()
    fun changeFloatActionIcon()
}