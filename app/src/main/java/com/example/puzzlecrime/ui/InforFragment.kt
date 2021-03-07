package com.example.puzzlecrime.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.FragmentInforBinding

class InforFragment : Fragment() {

    lateinit var binding:FragmentInforBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_infor,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnclickForumClick()
        setOnclickWebLink()
    }

    fun setOnclickWebLink(){
        binding.linkWeb.setOnClickListener {
            val goToWebViewFragment = InforFragmentDirections.actionInforFragmentToWebAndForumFragment(binding.linkWeb.text.toString())
            findNavController().navigate(goToWebViewFragment)
        }
    }
    fun setOnclickForumClick(){
        binding.linkForum.setOnClickListener {
            val goToWebViewFragment = InforFragmentDirections
                .actionInforFragmentToWebAndForumFragment("https://www.puzzleprime.com/forums/forum/puzzle-stories/puzzle-crime/")
            findNavController().navigate(goToWebViewFragment)
        }
    }
}