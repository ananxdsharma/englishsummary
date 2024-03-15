package com.example.englishsummary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class PostActivity : AppCompatActivity() {
    private lateinit var postViewModel: PostViewModel
    private lateinit var repo: PostRepo
    private lateinit var postViewModelFactory: PostViewModelFactory
    private lateinit var postAdapter: PostAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)


        init()

        postViewModel.fetchPostsDetail()
        postViewModel.postLiveData.observe(this){
            val recyclerView = findViewById<RecyclerView>(R.id.post_rv)
            recyclerView.layoutManager = LinearLayoutManager(this)
            postAdapter = PostAdapter(it)
            recyclerView.adapter = postAdapter
        }



    }
    private fun init(){
        repo= PostRepo(RetrofitBuilder.getInstance())
        postViewModelFactory= PostViewModelFactory(repo)
        postViewModel= ViewModelProvider(this,postViewModelFactory)[PostViewModel::class.java]
    }
}