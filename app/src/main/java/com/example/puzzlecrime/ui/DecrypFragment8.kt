package com.example.puzzlecrime.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.FragmentDecryp8Binding
import com.example.puzzlecrime.ui.dialog.InputPasscodeDialog


class DecrypFragment8 : Fragment() {


    lateinit var binding:FragmentDecryp8Binding
    val args:DecrypFragment8Args by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_decryp_8,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickFloatBtn()
    }

    fun onClickFloatBtn(){
        binding.floatingActionButton8.setOnClickListener {
            val dialog = InputPasscodeDialog(args.stage,binding.titelStage8.text.toString())
            dialog.show(requireActivity().supportFragmentManager,"InputPasscodeDialog")
        }
    }
}