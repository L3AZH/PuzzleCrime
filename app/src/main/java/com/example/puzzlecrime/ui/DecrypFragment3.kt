package com.example.puzzlecrime.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.FragmentDecryp3Binding
import com.example.puzzlecrime.ui.dialog.InputPasscodeDialog

class DecrypFragment3:Fragment() {

    lateinit var binding:FragmentDecryp3Binding
    val args:DecrypFragment3Args by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_decryp_3,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickFloatButton()
    }
    fun onClickFloatButton(){
        binding.floatingActionButton3.setOnClickListener {
            val dialog = InputPasscodeDialog(args.stage,binding.titleStage3.text.toString())
            dialog.isCancelable = false
            dialog.show(requireActivity().supportFragmentManager,"InputPasscodeDialog")
        }
    }

}