package com.example.puzzlecrime.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.puzzlecrime.MainActivity
import com.example.puzzlecrime.R
import com.example.puzzlecrime.StageViewModel
import com.example.puzzlecrime.adapter.StageAdapter
import com.example.puzzlecrime.databinding.FragmentHomeBinding
import com.example.puzzlecrime.model.Stage


class HomeFragment : Fragment() {
    lateinit var stageAdpater:StageAdapter
    lateinit var binding:FragmentHomeBinding
    lateinit var viewModel:StageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setUpRecycleView()
        stageAdpater.setOnClickListener {
            onClickStage(it)
        }
    }

    fun setUpRecycleView(){
        binding.recyclerView.apply {
            stageAdpater = StageAdapter()
            layoutManager = LinearLayoutManager(activity)
            adapter = stageAdpater
        }
        displayRecycle()
    }
    fun displayRecycle(){
        viewModel.getData().observe(viewLifecycleOwner, Observer {
            if(it.isEmpty()){
                viewModel.initData()
            }
            stageAdpater.differ.submitList(it)
        })
    }
    fun onClickStage(stage:Stage){
        val goToDecrypFragment = HomeFragmentDirections.let {
            when(stage.id){
                0->{
                    it.actionHomeFragmentToDecrypFragment(stage)
                }
                1->{
                    it.actionHomeFragmentToDecrypFragment1(stage)
                }
                2->{
                    it.actionHomeFragmentToDecrypFragment2(stage)
                }
                3->{
                    it.actionHomeFragmentToDecrypFragment3(stage)
                }
                4->{
                    it.actionHomeFragmentToDecrypFragment4(stage)
                }
                5->{
                    it.actionHomeFragmentToDecrypFragment5(stage)
                }
                6->{
                    it.actionHomeFragmentToDecrypFragment6(stage)
                }
                7->{
                    it.actionHomeFragmentToDecrypFragment7(stage)
                }
                8->{
                    it.actionHomeFragmentToDecrypFragment8(stage)
                }
                else->{
                    it.actionHomeFragmentToDecrypFragment(stage)
                }
            }
        }
        findNavController().navigate(goToDecrypFragment)
    }
}