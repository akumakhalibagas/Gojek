package com.makhalibagas.gojek.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.makhalibagas.gojek.databinding.ItemsContentBinding

class ContentAdapter(private var listContent: List<String>) : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    class ViewHolder(val binding : ItemsContentBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(content : String){
            binding.title.text = content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemsContentBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val content = listContent[position]
        holder.bind(content)

    }

    override fun getItemCount(): Int = listContent.size
}