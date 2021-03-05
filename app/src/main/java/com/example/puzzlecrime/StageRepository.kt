package com.example.puzzlecrime

import androidx.lifecycle.LiveData
import com.example.puzzlecrime.db.StageDAO
import com.example.puzzlecrime.model.Stage

class StageRepository(val stageDAO: StageDAO) {
    suspend fun unlockNewStage(stage:Stage){
        stageDAO.insert(stage)
    }
    fun getAllStage():LiveData<List<Stage>>{
        return stageDAO.getAllStage()
    }
    suspend fun updateStage(stage: Stage){
        stageDAO.update(stage)
    }
    fun checkStageExistInData(idStage: Int):Boolean{
        return stageDAO.checkStageExist(idStage)
    }
}