package com.example.puzzlecrime

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.puzzlecrime.databinding.ActivityMainBinding
import com.example.puzzlecrime.db.StageDAO
import com.example.puzzlecrime.db.StageDatabase

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var viewModel: StageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_PuzzleCrime)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val dao = StageDatabase(this).getStageDao()
        val stageRepository = StageRepository(dao)
        val stageViewModelFactory = StageViewModelFactory(stageRepository)
        viewModel = ViewModelProvider(this,stageViewModelFactory).get(StageViewModel::class.java)
        binding.lifecycleOwner=this

        //lưu key trò chơi
        viewModel.initDataPreference(this)

        val navHostFragment = supportFragmentManager.findFragmentByTag("navHostFragment")
        binding.bottomNavigationView.setupWithNavController(navHostFragment!!.findNavController())
    }
}