package com.example.puzzlecrime.db

import android.app.Activity
import android.content.Context
import com.example.puzzlecrime.MainActivity

class SharePreferenceInstance(val activity: Activity) {
    fun initDataSharePreference(){
        val sharedPreferences = activity?.getPreferences(Context.MODE_PRIVATE)?:return
        if (sharedPreferences.all.size == 0){
            with(sharedPreferences.edit()){
                putInt("0",1502)
                putInt("1",2021)
                putInt("2",1713)
                putInt("3",3106)
                putInt("4",9726)
                putInt("5",5972)
                //putInt("6",5623)
                apply()
            }
        }
//        with(sharedPreferences.edit()){
//                putInt("1",1502)
//                apply()
//        }
    }
    fun checkKey(idStage:Int,keyInput:Int):Boolean{
        val sharePreferenceInstance = activity?.getPreferences(Context.MODE_PRIVATE)
        val StageKey = sharePreferenceInstance.getInt("${idStage}",-1)
        return keyInput == StageKey
    }
}