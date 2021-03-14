package com.example.puzzlecrime.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.puzzlecrime.model.Stage
import java.util.*

@Database(entities = [Stage::class],version = 1)
abstract class StageDatabase:RoomDatabase() {
    abstract fun getStageDao():StageDAO
    

    companion object{
        @Volatile
        private var instance: StageDatabase?=null
        private val LOCK = Any()
        operator fun invoke(context: Context)=instance ?:kotlin.synchronized(LOCK){
            instance ?: createDatabase(context).also {
                Log.i("StageDatabase","set up create database first time")
                instance = it
            }
        }
        private fun createDatabase(context: Context): StageDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                StageDatabase::class.java,
                "game_database.db"
            ).build()
        }
    }
}