package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemDocBinding

class DocAdapter(private val items: List<DocModel>) :
    RecyclerView.Adapter<DocAdapter.DocViewHolder>() {

    class DocViewHolder(val binding: ItemDocBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocViewHolder {
        val binding = ItemDocBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DocViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DocViewHolder, position: Int) {
        val item = items[position]
        holder.binding.textViewTitle.text = item.title
        holder.binding.textViewContext.text = item.context
    }

    override fun getItemCount() = items.size
}
