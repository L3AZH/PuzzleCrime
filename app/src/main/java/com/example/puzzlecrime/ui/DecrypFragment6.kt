package com.example.puzzlecrime.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.davemorrissey.labs.subscaleview.ImageSource
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.FragmentDecryp6Binding
import com.example.puzzlecrime.ui.dialog.InputPasscodeDialog


class DecrypFragment6 : Fragment() {

    lateinit var binding:FragmentDecryp6Binding
    val args:DecrypFragment6Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_decryp_6,container,false)
        binding.picStage6.setImage(ImageSource.resource(R.drawable.picstage7))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickFloatButton()
    }
    fun onClickFloatButton(){
        binding.floatingActionButton6.setOnClickListener {
            val dialog = InputPasscodeDialog(args.stage,binding.titleStage6.text.toString())
            dialog.isCancelable = false
            dialog.show(requireActivity().supportFragmentManager,"InputPasscodeDialog")
        }
    }
}