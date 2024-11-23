package com.example.englishsummary

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class PostPagingAdapter(private val listener: OnPostItemClickListener) : PagingDataAdapter<Post, PostPagingAdapter.PostViewHolder>(COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_article_layout, parent, false)
        return PostViewHolder(view)
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postTitle: TextView = itemView.findViewById(R.id.post_title)
        val postSummary: TextView = itemView.findViewById(R.id.post_summary)
        val readMore: TextView = itemView.findViewById(R.id.read_more)
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Post>() {
            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.postTitle.text = currentItem.title.rendered
            val htmlString = currentItem.excerpt.rendered
            val htmlStringContent = currentItem.content.rendered
            val linkOfSite = currentItem.link
            val plainText = HtmlCompat.fromHtml(htmlString, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
            val plainTextContent = HtmlCompat.fromHtml(htmlStringContent, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
            holder.postSummary.text = plainText
            holder.readMore.text = "Read more"
            holder.itemView.setOnClickListener {
                Log.i("jacob","$linkOfSite in adapter")
                listener.onItemClick(linkOfSite)
            }
        }
    }
}