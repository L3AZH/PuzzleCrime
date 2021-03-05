package com.example.puzzlecrime.stage2extra


import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.FragmentCardLayoutBinding


class CardFragment:Fragment() {
    lateinit var binding:FragmentCardLayoutBinding
    var stateCardFont:Boolean = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i("L3checkCreate", "onCreateView")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_card_layout, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("L3checkCreate", "onCreateView")
        onclickFloatBtn()
        initEventOnclickPiece()

    }

    fun FontImg(){
        binding.imageView1Back.visibility = View.INVISIBLE
        binding.imageView1.visibility = View.VISIBLE

        binding.imageView2Back.visibility = View.INVISIBLE
        binding.imageView2.visibility = View.VISIBLE

        binding.imageView3Back.visibility = View.INVISIBLE
        binding.imageView3.visibility = View.VISIBLE

        binding.imageView4Back.visibility = View.INVISIBLE
        binding.imageView4.visibility = View.VISIBLE

        binding.imageView5Back.visibility = View.INVISIBLE
        binding.imageView5.visibility = View.VISIBLE

        binding.imageView6Back.visibility = View.INVISIBLE
        binding.imageView6.visibility = View.VISIBLE

        binding.imageView7Back.visibility = View.INVISIBLE
        binding.imageView7.visibility = View.VISIBLE

        binding.imageView8Back.visibility = View.INVISIBLE
        binding.imageView8.visibility = View.VISIBLE

        binding.imageView9Back.visibility = View.INVISIBLE
        binding.imageView9.visibility = View.VISIBLE

        binding.imageView10Back.visibility = View.INVISIBLE
        binding.imageView10.visibility = View.VISIBLE

    }
    fun BackImg(){
        binding.imageView1Back.visibility = View.VISIBLE
        binding.imageView1.visibility = View.INVISIBLE

        binding.imageView2Back.visibility = View.VISIBLE
        binding.imageView2.visibility = View.INVISIBLE

        binding.imageView3Back.visibility = View.VISIBLE
        binding.imageView3.visibility = View.INVISIBLE

        binding.imageView4Back.visibility = View.VISIBLE
        binding.imageView4.visibility = View.INVISIBLE

        binding.imageView5Back.visibility = View.VISIBLE
        binding.imageView5.visibility = View.INVISIBLE

        binding.imageView6Back.visibility = View.VISIBLE
        binding.imageView6.visibility = View.INVISIBLE

        binding.imageView7Back.visibility = View.VISIBLE
        binding.imageView7.visibility = View.INVISIBLE

        binding.imageView8Back.visibility = View.VISIBLE
        binding.imageView8.visibility = View.INVISIBLE

        binding.imageView9Back.visibility = View.VISIBLE
        binding.imageView9.visibility = View.INVISIBLE

        binding.imageView10Back.visibility = View.VISIBLE
        binding.imageView10.visibility = View.INVISIBLE

    }
    fun initEventOnclickPiece(){
        binding.piece1.setOnClickListener {
            rotate(binding.imageView1)
            rotate(binding.imageView1Back)
        }
        binding.piece2.setOnClickListener {
            rotate(binding.imageView2)
            rotate(binding.imageView2Back)
        }
        binding.piece3.setOnClickListener {
            rotate(binding.imageView3)
            rotate(binding.imageView3Back)
        }
        binding.piece4.setOnClickListener {
            rotate(binding.imageView4)
            rotate(binding.imageView4Back)
        }
        binding.piece5.setOnClickListener {
            rotate(binding.imageView5)
            rotate(binding.imageView5Back)
        }
        binding.piece6.setOnClickListener {
            rotate(binding.imageView6)
            rotate(binding.imageView6Back)
        }
        binding.piece7.setOnClickListener {
            rotate(binding.imageView7)
            rotate(binding.imageView7Back)
        }
        binding.piece8.setOnClickListener {
            rotate(binding.imageView8)
            rotate(binding.imageView8Back)
        }
        binding.piece9.setOnClickListener {
            rotate(binding.imageView9)
            rotate(binding.imageView9Back)
        }
        binding.piece10.setOnClickListener {
            rotate(binding.imageView10)
            rotate(binding.imageView10Back)
        }
    }
    fun rotate(imgView: ImageView){
        when(imgView.rotation){
            0f -> {
                imgView.rotation = 90f
            }
            90f -> {
                imgView.rotation = 180f
            }
            180f -> {
                imgView.rotation = 270f
            }
            270f -> {
                imgView.rotation = 360f
            }
            else->{
                imgView.rotation = 90f
            }
        }
    }
    fun onclickFloatBtn(){
        binding.floatingActionButton2.setOnClickListener {
            if(stateCardFont){
                BackImg()
                stateCardFont = false
            }
            else{
                FontImg()
                stateCardFont = true
            }
        }
    }
    fun addtoLayout(){
        binding.parentCooridnatorLayout.addDraggableChild(binding.piece1)
        binding.parentCooridnatorLayout.addDraggableChild(binding.piece2)
        binding.parentCooridnatorLayout.addDraggableChild(binding.piece3)
        binding.parentCooridnatorLayout.addDraggableChild(binding.piece4)
        binding.parentCooridnatorLayout.addDraggableChild(binding.piece5)
        binding.parentCooridnatorLayout.addDraggableChild(binding.piece6)
        binding.parentCooridnatorLayout.addDraggableChild(binding.piece7)
        binding.parentCooridnatorLayout.addDraggableChild(binding.piece8)
        binding.parentCooridnatorLayout.addDraggableChild(binding.piece9)
        binding.parentCooridnatorLayout.addDraggableChild(binding.piece10)
        binding.parentCooridnatorLayout.setViewDragListener(object : DraggableCoordinatorLayout.ViewDragListener {
            override fun onViewCaptured(view: View, i: Int) {
                when (view.id) {
                    R.id.piece1 -> {
                        binding.piece1.isDragged = true
                    }
                    R.id.piece2 -> {
                        binding.piece2.isDragged = true
                    }
                    R.id.piece3 -> {
                        binding.piece3.isDragged = true
                    }
                    R.id.piece4 -> {
                        binding.piece4.isDragged = true
                    }
                    R.id.piece5 -> {
                        binding.piece5.isDragged = true
                    }
                    R.id.piece6 -> {
                        binding.piece6.isDragged = true
                    }
                    R.id.piece7 -> {
                        binding.piece7.isDragged = true
                    }
                    R.id.piece8 -> {
                        binding.piece8.isDragged = true
                    }
                    R.id.piece9 -> {
                        binding.piece9.isDragged = true
                    }
                    R.id.piece10 -> {
                        binding.piece10.isDragged = true
                    }
                }
            }

            override fun onViewReleased(view: View, v: Float, v1: Float) {
                when (view.id) {
                    R.id.piece1 -> {
                        binding.piece1.isDragged = false
                    }
                    R.id.piece2 -> {
                        binding.piece2.isDragged = false
                    }
                    R.id.piece3 -> {
                        binding.piece3.isDragged = false
                    }
                    R.id.piece4 -> {
                        binding.piece4.isDragged = false
                    }
                    R.id.piece5 -> {
                        binding.piece5.isDragged = false
                    }
                    R.id.piece6 -> {
                        binding.piece6.isDragged = false
                    }
                    R.id.piece7 -> {
                        binding.piece7.isDragged = false
                    }
                    R.id.piece8 -> {
                        binding.piece8.isDragged = false
                    }
                    R.id.piece9 -> {
                        binding.piece9.isDragged = false
                    }
                    R.id.piece10 -> {
                        binding.piece10.isDragged = false
                    }
                }
            }
        })
    }
}