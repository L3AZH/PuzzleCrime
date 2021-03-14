package com.example.puzzlecrime.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.puzzlecrime.R
import com.example.puzzlecrime.stageextra.stage7extra.PicStage7ViewPageAdapter
import com.example.puzzlecrime.databinding.FragmentDecryp7Binding
import com.example.puzzlecrime.ui.dialog.InputPasscodeDialog
import com.google.android.material.tabs.TabLayoutMediator

class DecrypFragment7 : Fragment() {

    lateinit var binding:FragmentDecryp7Binding
    lateinit var viewPagerAdapter: PicStage7ViewPageAdapter
    val args:DecrypFragment7Args by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_decryp_7,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickFoatBtn()
        setupViewPageAndTabLayout()
    }

    fun setupViewPageAndTabLayout(){
        val listPic = listOf(
            R.drawable.picstage8,
            R.drawable.picstage81,
            R.drawable.picstage82,
            R.drawable.picstage83
        )
        viewPagerAdapter = PicStage7ViewPageAdapter(listPic)
        binding.viewPage.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayout,binding.viewPage){ tab, position->
            tab.text = "Pic ${position}"
        }.attach()
    }

    fun onClickFoatBtn(){
        binding.floatingActionButton7.setOnClickListener {
            val diaLog = InputPasscodeDialog(args.stage,binding.titleStage7.text.toString())
            diaLog.isCancelable = false
            diaLog.show(requireActivity().supportFragmentManager,"InputPasscodeDialog")
        }
    }
}