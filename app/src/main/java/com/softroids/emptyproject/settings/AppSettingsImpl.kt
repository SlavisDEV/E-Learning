package com.softroids.emptyproject.settings

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import java.util.ArrayList
import java.util.HashMap

private const val SETTINGS_NAME = "app_settings"
private const val SETTINGS_RESULTS = "settings_results"

class AppSettingsImpl(context: Context) : AppSettings {

    private val appContext = context.applicationContext


    private fun saveToSettings(key: String, value: String) {
        val settings: SharedPreferences =
            appContext.getSharedPreferences(SETTINGS_NAME, Activity.MODE_PRIVATE)
        val preferencesEditor = settings.edit()
        preferencesEditor.putString(key, value)
        preferencesEditor.apply()
    }

    private fun saveToSettings(key: String, value: Int) {
        val settings =
            appContext.getSharedPreferences(SETTINGS_NAME, Activity.MODE_PRIVATE)
        val preferencesEditor = settings.edit()
        preferencesEditor.putInt(key, value)
        preferencesEditor.apply()
    }

    private fun loadIntFromSettings(key: String): Int {
        val settings =
            appContext.getSharedPreferences(SETTINGS_NAME, Activity.MODE_PRIVATE)
        return settings.getInt(key, -1)
    }

    private fun loadFromSettings(key: String): String? {
        val settings =
            appContext.getSharedPreferences(SETTINGS_NAME, Activity.MODE_PRIVATE)
        return settings.getString(key, null)
    }

    override fun saveAnswers(results: HashMap<Int, ArrayList<Int>>) {
        saveToSettings(SETTINGS_RESULTS, Gson().toJson(results))
    }

    override fun getAnswers(): HashMap<Int, ArrayList<Int>> {
        val json = loadFromSettings(SETTINGS_RESULTS)!!
        val deserialized = Gson().fromJson(json, HashMap<String, ArrayList<Double>>()::class.java)
        val result = hashMapOf<Int, ArrayList<Int>>()
        deserialized.forEach { (index, answers) ->
            result[index.toInt()] = answers.map { it.toInt() } as ArrayList<Int>
        }
        return result
    }
}