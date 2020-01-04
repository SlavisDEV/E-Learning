package com.softroids.emptyproject.ui.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.softroids.emptyproject.R
import com.softroids.emptyproject.databinding.ActivityLearningBinding
import com.softroids.emptyproject.di.base.App
import kotlinx.android.synthetic.main.activity_learning.*
import javax.inject.Inject

class LearningActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityLearningBinding

//    @Inject
//    protected lateinit var model: LearningActivityViewModel

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning)

//        App.get(this)
//            .getAppComponent()
//            .plus(LearningActivityModule(this))
//            .inject(this)

        navController = Navigation.findNavController(this, R.id.fragment_host)
        bottomNavigationView.setupWithNavController(navController)

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_learning)
//        binding.apply {
//            lifecycleOwner = this@LearningActivity
//            model = this@LearningActivity.model
//            viewAccess = this@LearningActivity
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }
}
