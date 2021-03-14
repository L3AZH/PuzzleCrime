package com.example.puzzlecrime.stageextra.stage7extra

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.ItemPicStage7LayoutBinding

class PicStage7ViewPageAdapter(val listPic: List<Int>) :
    RecyclerView.Adapter<PicStage7ViewPageAdapter.PicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: ItemPicStage7LayoutBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_pic_stage7_layout, parent, false)
        return PicViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PicViewHolder, position: Int) {
        holder.binding(listPic[position])
    }

    override fun getItemCount(): Int {
        return listPic.size
    }

    inner class PicViewHolder(val itemBinding: ItemPicStage7LayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun binding(picResource: Int) {
            itemBinding.imageView.setImageResource(picResource)
        }
    }
}