package com.example.englishsummary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private var titleList: List<CategoryArchive>,private val listener: OnSeeAllButtonClickListener) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val archiveHeading:TextView=itemView.findViewById(R.id.archive_heading)
        val archive1: TextView = itemView.findViewById(R.id.tv1)
        val archive2: TextView = itemView.findViewById(R.id.tv2)
        val archive3: TextView = itemView.findViewById(R.id.tv3)
        val btn: Button =itemView.findViewById(R.id.btn_seeall)
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

        val passID: Int =currentItem.cId
        holder.btn.setOnClickListener{
            listener.onSeeAllClick(passID)
        }
    }

    override fun getItemCount(): Int {
        return titleList.size
    }


}