package com.softroids.emptyproject.settings

import java.util.ArrayList
import java.util.HashMap

interface AppSettings {

    fun saveAnswers(results: HashMap<Int, ArrayList<Int>>)
    fun getAnswers(): HashMap<Int, ArrayList<Int>>
}