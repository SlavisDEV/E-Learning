package com.softroids.emptyproject.ui.results

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.softroids.emptyproject.R
import com.softroids.emptyproject.databinding.ActivityResultsBinding
import com.softroids.emptyproject.di.base.App
import com.softroids.emptyproject.di.ui.results.ResultsActivityModule
import javax.inject.Inject

class ResultsActivity : AppCompatActivity(), ResultsActivityViewAccess {

    private lateinit var binding: ActivityResultsBinding

    @Inject
    protected lateinit var model: ResultsActivityViewModel

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
    }
}
