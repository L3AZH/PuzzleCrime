package com.example.puzzlecrime.stageextra.stage4extra

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.CharaterDialogLayoutBinding

class CharaterDiaLog(val character:String, val codeColor: String):DialogFragment() {

    lateinit var binding:CharaterDialogLayoutBinding


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return  activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            binding = DataBindingUtil.inflate(inflater, R.layout.charater_dialog_layout,null,false)
            builder.setView(binding.root)
            binding.character.text = character
            binding.character.setTextColor(Color.parseColor(codeColor))
            builder.create()
        }?:throw IllegalStateException("Activity can not be null ")
    }
}