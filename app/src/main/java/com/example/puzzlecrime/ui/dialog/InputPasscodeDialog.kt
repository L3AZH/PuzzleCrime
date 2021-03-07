package com.example.puzzlecrime.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.puzzlecrime.App
import com.example.puzzlecrime.MainActivity
import com.example.puzzlecrime.R
import com.example.puzzlecrime.StageViewModel
import com.example.puzzlecrime.databinding.InputPasscodeLayoutBinding
import com.example.puzzlecrime.model.Stage
import com.google.android.material.snackbar.Snackbar
import java.lang.IllegalStateException

class InputPasscodeDialog(val stage: Stage,val nameCurrentStage:String):DialogFragment() {
    lateinit var binding:InputPasscodeLayoutBinding
    lateinit var viewModel:StageViewModel
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       return activity?.let {
           val builder = AlertDialog.Builder(it)
           val inflater = requireActivity().layoutInflater
           viewModel = (requireActivity() as MainActivity).viewModel
           binding = DataBindingUtil.inflate(inflater,R.layout.input_passcode_layout,null,false)
           builder.setView(binding.root)

           setOnclickContinueButton()
           setOnclickCancelBtn()

           builder.create()
       }?:throw IllegalStateException("Activity can not be null")
    }
    fun setOnclickContinueButton(){
        binding.continueBtn.setOnClickListener {
            if(binding.passcodeEditText.text.toString().isEmpty()){
                Snackbar.make(binding.root,"Please enter the passcode",Snackbar.LENGTH_LONG).show()
            }
            else{
                val flag = viewModel.checkPasscode(requireActivity(),stage.id,binding.passcodeEditText.text.toString().toInt())
                if(flag){
                    val activityIntent = Intent(requireContext(),MainActivity::class.java)
                    val pendingIntent = PendingIntent.getActivity(requireContext(),0,activityIntent,0)
                    val notification = NotificationCompat.Builder(requireContext(),App.CHANNEL_ID_1)
                            .setSmallIcon(R.drawable.ic_baseline_home_24)
                            .setContentTitle("Pass code correct!!")
                            .setContentText("Unlock stage: ${stage.id+1} ")
                            .setLargeIcon(BitmapFactory.decodeResource(requireActivity().getResources(), R.drawable.img_home))
                            .setContentIntent(pendingIntent)
                            .setCategory(Notification.CATEGORY_NAVIGATION)
                            .setAutoCancel(true)
                            .setColor(Color.MAGENTA)
                            .build()
                    val ID_noti = 1
                    with(NotificationManagerCompat.from(requireContext())){
                        notify(ID_noti,notification)
                    }
                    viewModel.unlockNextStage(stage,nameCurrentStage,binding.passcodeEditText.text.toString().toInt())
                    dialog?.cancel()
                }
                else{
                    Snackbar.make(binding.root,"Wrong passcode ${flag}",Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun setOnclickCancelBtn(){
        binding.cancleBtn.setOnClickListener {
            dialog?.cancel()
        }
    }
}