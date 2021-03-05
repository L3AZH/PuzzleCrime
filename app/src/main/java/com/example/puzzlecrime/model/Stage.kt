package com.example.puzzlecrime.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "stage_table")
data class Stage(
    @PrimaryKey
    @ColumnInfo(name = "id_stage")
    val id:Int,
    var name:String,
    var key:Int
):Serializable {

}