package com.example.englishsummary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PostActivity : AppCompatActivity(),OnPostItemClickListener {
    private lateinit var postViewModel: PostViewModel
    private lateinit var repo: PostRepo
    private lateinit var postViewModelFactory: PostViewModelFactory
    private lateinit var postAdapter: PostAdapter





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        val intent = intent

        // Retrieve the parameter value using the key
        val parameterValue = intent.getIntExtra("passID", -1)
        Log.i("kunj","the value in PostActivity $parameterValue")

        val  menubutton = findViewById<ImageView>(R.id.toggle_btn)
        val navmenu = findViewById<LinearLayout>(R.id.menu_option_sec)
        val loadingbar=findViewById<ProgressBar>(R.id.pbar)

        menubutton.setOnClickListener {
            if (navmenu.visibility == View.GONE) {
                navmenu.visibility = View.VISIBLE
            } else {
                navmenu.visibility = View.GONE
            }
        }


        init()

        postViewModel.fetchPostsDetail(parameterValue)
        postViewModel.postLiveData.observe(this){
            val recyclerView = findViewById<RecyclerView>(R.id.post_rv)
            recyclerView.layoutManager = LinearLayoutManager(this)
            postAdapter = PostAdapter(it,this)
            recyclerView.adapter = postAdapter
        }
        postViewModel.isLoading.observe(this){
            if(it){
                loadingbar.visibility=View.VISIBLE
            }
            else{
                loadingbar.visibility=View.INVISIBLE
            }
        }
    }
    private fun init(){
        repo= PostRepo(RetrofitBuilder.getInstance())
        postViewModelFactory= PostViewModelFactory(repo)
        postViewModel= ViewModelProvider(this,postViewModelFactory)[PostViewModel::class.java]
    }

    override fun onItemClick(position: Int, link: String) {
        val intent = Intent(this, ContentDetailActivity::class.java)
        intent.putExtra("link", link)
        startActivity(intent)
    }
}