package com.softroids.emptyproject.data.model

data class Question(
    val question: String,
    val answers: HashMap<Int, Pair<String, Boolean>>
)