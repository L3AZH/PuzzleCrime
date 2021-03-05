package com.example.puzzlecrime.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.FragmentDecryp1Binding
import com.example.puzzlecrime.databinding.FragmentDecryp2Binding
import com.example.puzzlecrime.databinding.FragmentDecrypBinding
import com.example.puzzlecrime.ui.Dialog.InputPasscodeDialog


class DecrypFragment2 : Fragment() {

    lateinit var binding: FragmentDecryp2Binding
    val args:DecrypFragment2Args by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_decryp_2,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickFloatButton()
        onclickButton()
    }

    fun onClickFloatButton(){
        binding.floatingActionButton.setOnClickListener {
            val dialog = InputPasscodeDialog(args.stage,binding.titleStage2.text.toString())
            dialog.show(requireActivity().supportFragmentManager,"InputPasscodeDialog")
        }
    }

    fun onclickButton(){
        binding.button.setOnClickListener {
            val goToCardFragment = DecrypFragment2Directions.actionDecrypFragment2ToCardFragment()
            findNavController().navigate(goToCardFragment)
        }
    }


}