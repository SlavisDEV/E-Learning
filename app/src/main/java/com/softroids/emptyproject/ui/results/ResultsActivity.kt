package com.softroids.emptyproject.ui.results

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.softroids.emptyproject.R
import com.softroids.emptyproject.data.QuizManager
import com.softroids.emptyproject.data.adapter.ResultAdapter
import com.softroids.emptyproject.databinding.ActivityResultsBinding
import com.softroids.emptyproject.di.base.App
import com.softroids.emptyproject.di.ui.results.ResultsActivityModule
import com.softroids.emptyproject.settings.AppSettings
import kotlinx.android.synthetic.main.activity_results.*
import javax.inject.Inject

class ResultsActivity : AppCompatActivity(), ResultsActivityViewAccess {

    private lateinit var binding: ActivityResultsBinding

    @Inject
    protected lateinit var model: ResultsActivityViewModel

    private lateinit var resultAdapter: ResultAdapter

    @Inject
    protected lateinit var quizManager: QuizManager

    @Inject
    protected lateinit var appSettings: AppSettings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.get(this)
            .getAppComponent()
            .plus(ResultsActivityModule(this))
            .inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_results)
        binding.apply {
            lifecycleOwner = this@ResultsActivity
            model = this@ResultsActivity.model
            viewAccess = this@ResultsActivity
        }

        initResultsRecyclerView()
    }

    private fun initResultsRecyclerView() {
        resultAdapter = ResultAdapter(quizManager.questions, appSettings.getAnswers(), this)
        recyclerView_results.apply {
            layoutManager = LinearLayoutManager(
                this@ResultsActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = resultAdapter
        }
    }
}
