package com.example.puzzlecrime.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.puzzlecrime.model.Stage

@Dao
interface StageDAO {
    @Insert
    suspend fun insert(stage: Stage):Long

    @Update
    suspend fun update(stage: Stage)

    @Query("select * from stage_table")
    fun getAllStage():LiveData<List<Stage>>

    @Query("select * from stage_table where id_stage = :idinput")
    fun checkStageExist(idinput:Int):Boolean

}