package com.example.puzzlecrime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StageViewModelFactory(val stageRepository: StageRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StageViewModel::class.java)){
            return StageViewModel(stageRepository) as T
        }
        throw IllegalArgumentException("Unkown View Model ")
    }
}