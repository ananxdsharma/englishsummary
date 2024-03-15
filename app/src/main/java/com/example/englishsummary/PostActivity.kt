package com.example.englishsummary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
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

        val  menubutton = findViewById<ImageView>(R.id.toggle_btn)
        val navmenu = findViewById<LinearLayout>(R.id.menu_option_sec)
        val Loadingbar=findViewById<ProgressBar>(R.id.pbar)

        menubutton.setOnClickListener {
            if (navmenu.visibility == View.GONE) {
                navmenu.visibility = View.VISIBLE
            } else {
                navmenu.visibility = View.GONE
            }
        }


        init()

        postViewModel.fetchPostsDetail()
        postViewModel.postLiveData.observe(this){
            val recyclerView = findViewById<RecyclerView>(R.id.post_rv)
            recyclerView.layoutManager = LinearLayoutManager(this)
            postAdapter = PostAdapter(it)
            recyclerView.adapter = postAdapter
        }
        postViewModel.isLoading.observe(this){
            if(it){
                Loadingbar.visibility=View.VISIBLE
            }
            else{
                Loadingbar.visibility=View.INVISIBLE
            }
        }



    }
    private fun init(){
        repo= PostRepo(RetrofitBuilder.getInstance())
        postViewModelFactory= PostViewModelFactory(repo)
        postViewModel= ViewModelProvider(this,postViewModelFactory)[PostViewModel::class.java]
    }
}