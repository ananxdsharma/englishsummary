package com.example.englishsummary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private var titleList: List<CategoryArchive>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val archive1: TextView = itemView.findViewById(R.id.tv1)
        val archive2: TextView = itemView.findViewById(R.id.tv2)
        val archive3: TextView = itemView.findViewById(R.id.tv3)
    }

//    // another function
//
//    fun updatePosts(newPosts: List<Post>) {
//        postList = newPosts
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.categorycardlayout, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentItem = titleList[position]
        holder.archive1.text = currentItem.p1
        holder.archive2.text = currentItem.p2
        holder.archive3.text = currentItem.p3

    }


    override fun getItemCount(): Int {
        return titleList.size
    }



}