package com.example.puzzlecrime.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.FragmentDecryp1Binding
import com.example.puzzlecrime.ui.dialog.InputPasscodeDialog

class DecrypFragment1 : Fragment() {

    lateinit var binding1: FragmentDecryp1Binding
    val args:DecrypFragment1Args by navArgs()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding1 = DataBindingUtil.inflate(inflater, R.layout.fragment_decryp_1,container,false)
        return binding1.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickFloatButton()
    }

    fun onClickFloatButton(){
        binding1.floatingActionButton1.setOnClickListener {
            val dialog = InputPasscodeDialog(args.stage,binding1.titleStage1.text.toString())
            dialog.isCancelable = false
            dialog.show(requireActivity().supportFragmentManager,"InputPasscodeDialog")
        }
    }

}