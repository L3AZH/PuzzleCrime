package com.example.puzzlecrime

import android.app.Activity
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puzzlecrime.db.SharePreferenceInstance
import com.example.puzzlecrime.model.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StageViewModel(val stageRepository: StageRepository):ViewModel() {
    val TAG = "StageViewModel"
    fun initData(){
        val listStage = stageRepository.getAllStage()
        if(listStage.value.isNullOrEmpty()){
            viewModelScope.launch {
                Log.i(TAG,"set initData insert first value ... ")
                stageRepository.unlockNewStage(Stage(0,"Introdution",-1))
            }
        }
    }
    fun getData():LiveData<List<Stage>>{
        return stageRepository.getAllStage()
    }
    fun initDataPreference(activity: Activity){
        Log.i(TAG,"set initData insert key value ... ")
        val initData = SharePreferenceInstance(activity)
        initData.initDataSharePreference()
    }

    fun unlockNextStage(stage: Stage,currentStageName:String,currentKey:Int)= CoroutineScope(Dispatchers.Default).launch{
        stage.name = currentStageName
        stage.key = currentKey
        updateStage(stage)
        val isNextStageReady = checkStageIsUnlock(stage.id+1)
        if(!isNextStageReady){
            unlockStage(Stage(stage.id+1,"Stage ${stage.id+1}",-1))
        }
    }

    fun checkPasscode(activity: Activity,idStage:Int,passcode:Int):Boolean{
        return SharePreferenceInstance(activity).checkKey(idStage,passcode)
    }

    fun unlockStage(stage: Stage) = viewModelScope.launch {
        stageRepository.unlockNewStage(stage)
    }

    fun updateStage(stage: Stage) = viewModelScope.launch{
        stageRepository.updateStage(stage)
    }
    fun checkStageIsUnlock(idStage:Int):Boolean{
        return stageRepository.checkStageExistInData(idStage)
    }
}