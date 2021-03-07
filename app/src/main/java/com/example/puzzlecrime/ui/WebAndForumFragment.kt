package com.example.puzzlecrime.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.FragmentWebAndForumBinding

class WebAndForumFragment : Fragment() {


    lateinit var bindind: FragmentWebAndForumBinding
    val args:WebAndForumFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        bindind = DataBindingUtil.inflate(inflater,R.layout.fragment_web_and_forum,container,false)
        return bindind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpWebView()
        setOnClickBackBtn()
    }

    fun setUpWebView(){
        bindind.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(args.url)
        }
    }

    fun setOnClickBackBtn(){
        bindind.floatingActionButtonWeb.setOnClickListener {
            val gotoInformFragment = WebAndForumFragmentDirections.actionWebAndForumFragmentToInforFragment()
            findNavController().navigate(gotoInformFragment)
        }
    }
}
