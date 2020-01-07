package com.softroids.emptyproject.ui.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.softroids.emptyproject.R
import com.softroids.emptyproject.data.adapter.AnswerAdapter
import com.softroids.emptyproject.databinding.ActivityTestBinding
import com.softroids.emptyproject.di.base.App
import com.softroids.emptyproject.di.ui.test.TestActivityModule
import com.softroids.emptyproject.ui.results.ResultsActivity
import kotlinx.android.synthetic.main.activity_test.*
import javax.inject.Inject

class TestActivity : AppCompatActivity(), TestActivityViewAccess {

    private lateinit var binding: ActivityTestBinding

    @Inject
    protected lateinit var model: TestActivityViewModel

    private lateinit var answerAdapter: AnswerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.get(this)
            .getAppComponent()
            .plus(TestActivityModule(this))
            .inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_test)
        binding.apply {
            lifecycleOwner = this@TestActivity
            model = this@TestActivity.model
            viewAccess = this@TestActivity
        }

        model.setup()
    }

    override fun initAnswers(answers: HashMap<Int, Pair<String, Boolean>>) {
        answerAdapter = AnswerAdapter(answers, this, null) {
            model.selectAnswer(it)
        }
        recyclerView_answers.apply {
            layoutManager = LinearLayoutManager(
                this@TestActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = answerAdapter
        }
    }

    override fun finishQuiz() {
        AlertDialog.Builder(this).apply {
            setMessage(R.string.quiz_finished)
            setPositiveButton(R.string.button_ok) { dialog, _ ->
                dialog.dismiss()
                openResults()
            }
            show()
        }
    }

    private fun openResults() {
        val intent = Intent(this, ResultsActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }
        startActivity(intent)
    }

    override fun changeFloatActionIcon() {
        floatingActionButton.setImageResource(R.drawable.ic_action_check)
    }
}
