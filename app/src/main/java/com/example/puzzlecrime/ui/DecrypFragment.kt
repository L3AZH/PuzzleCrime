package com.example.puzzlecrime.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.FragmentDecrypBinding
import com.example.puzzlecrime.ui.dialog.InputPasscodeDialog

class DecrypFragment : Fragment() {

    lateinit var binding:FragmentDecrypBinding
    val args:DecrypFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_decryp,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickFloatButton()
    }

    fun onClickFloatButton(){
        binding.floatingActionButton.setOnClickListener {
            val dialog = InputPasscodeDialog(args.stage,binding.tiltleStage0.text.toString())
            dialog.isCancelable = false
            dialog.show(requireActivity().supportFragmentManager,"InputPasscodeDialog")
        }
    }

}