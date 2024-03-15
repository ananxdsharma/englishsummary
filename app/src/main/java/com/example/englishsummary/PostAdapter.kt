package com.example.englishsummary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private var postList: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postTitle: TextView = itemView.findViewById(R.id.post_title)
        val postSummary: WebView = itemView.findViewById(R.id.post_web_content)
        val readMore: TextView = itemView.findViewById(R.id.read_more)
    }

//    // another function
//
//    fun updatePosts(newPosts: List<Post>) {
//        postList = newPosts
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.post_article_layout, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = postList[position]
        holder.postTitle.text = currentItem.title.rendered
        holder.postSummary.loadData(currentItem.excerpt.rendered, "text/html; charset=utf-8", "UTF-8")
        holder.readMore.text = "Read more"
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}