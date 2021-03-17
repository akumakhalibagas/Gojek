package com.makhalibagas.gojek.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.makhalibagas.gojek.databinding.ItemsForyouBinding

class ForyouAdapter(private var listContent: List<Int>) : RecyclerView.Adapter<ForyouAdapter.ViewHolder>() {

    class ViewHolder(val binding : ItemsForyouBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(img : Int){
            binding.rounded.setImageResource(img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemsForyouBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val content = listContent[position]
        holder.bind(content)

    }

    override fun getItemCount(): Int = listContent.size
}