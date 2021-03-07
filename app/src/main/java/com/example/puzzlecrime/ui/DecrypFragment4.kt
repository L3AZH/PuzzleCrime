package com.example.puzzlecrime.ui

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.FragmentDecryp4Binding
import com.example.puzzlecrime.stageextra.stage4extra.CharaterDiaLog
import com.example.puzzlecrime.ui.dialog.InputPasscodeDialog
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.applyLinks

class DecrypFragment4 : Fragment() {

    lateinit var binding:FragmentDecryp4Binding
    val args:DecrypFragment4Args by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_decryp_4,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickFloatButton()
        setClickableAndColorForAClue()
    }
    fun onClickFloatButton(){
        binding.floatingActionButton4.setOnClickListener {
            val dialog = InputPasscodeDialog(args.stage,binding.titleStage4.text.toString())
            dialog.isCancelable = false
            dialog.show(requireActivity().supportFragmentManager,"InputPasscodeDialog")
        }
    }
    fun setClickableAndColorForAClue(){
        val hiddenMessage1 = Link("Flander")
            .setTextColor(Color.WHITE)
            .setBold(true)
            .setUnderlined(false)
            .setOnClickListener {
                val characterDialog = CharaterDiaLog("M","#6401CD")
                characterDialog.show(requireActivity().supportFragmentManager,"characterDialog")
            }
        val hiddenMessage2 = Link("Flanders")
            .setTextColor(Color.WHITE)
            .setBold(true)
            .setUnderlined(false)
            .setOnClickListener {
                val characterDialog = CharaterDiaLog("I","#310069")
                characterDialog.show(requireActivity().supportFragmentManager,"characterDialog")
            }
        val hiddenMessage3 = Link("Flanderss")
            .setTextColor(Color.WHITE)
            .setBold(true)
            .setUnderlined(false)
            .setOnClickListener {
                val characterDialog = CharaterDiaLog("E","#D097FE")
                characterDialog.show(requireActivity().supportFragmentManager,"characterDialog")
            }
        val hiddenMessage4 = Link("Flandersss")
            .setTextColor(Color.WHITE)
            .setBold(true)
            .setUnderlined(false)
            .setOnClickListener {
                val characterDialog = CharaterDiaLog("T","#9530FD")
                characterDialog.show(requireActivity().supportFragmentManager,"characterDialog")
            }
        binding.contentStage4.applyLinks(hiddenMessage1,hiddenMessage2)
        binding.contentStage41.applyLinks(hiddenMessage3,hiddenMessage4)
    }
}