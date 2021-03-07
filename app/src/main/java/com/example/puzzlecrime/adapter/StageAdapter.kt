package com.example.puzzlecrime.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.ItemStageReviewBinding
import com.example.puzzlecrime.model.Stage

class StageAdapter:RecyclerView.Adapter<StageViewHolder>(){

    private var onClickListener : ((Stage)->Unit)?=null
    fun setOnClickListener(listener:(Stage)->Unit){
        this.onClickListener = listener
    }

    val differCallback = object : DiffUtil.ItemCallback<Stage>(){
        override fun areItemsTheSame(oldItem: Stage, newItem: Stage): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Stage, newItem: Stage): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ItemStageReviewBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_stage_review,parent,false)
        return StageViewHolder(binding)

    }

    override fun onBindViewHolder(holder: StageViewHolder, position: Int) {
        holder.binding(differ.currentList[position],onClickListener)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}
class StageViewHolder(val itemBinding: ItemStageReviewBinding):RecyclerView.ViewHolder(itemBinding.root){
    fun binding(stage: Stage,listener: ((Stage) -> Unit)?){
        itemBinding.nameStage.text = stage.name
        itemView.setOnClickListener {
            listener?.let {
                it(stage)
            }
        }
    }
}