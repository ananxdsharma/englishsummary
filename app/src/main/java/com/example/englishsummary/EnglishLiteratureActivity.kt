package com.example.englishsummary


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Deferred

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch


 class EnglishLiteratureActivity : AppCompatActivity(), OnSeeAllButtonClickListener {

     private lateinit var categoryViewModel: CategoriesViewModel
     private lateinit var repo: PostRepo
     private lateinit var categoryViewModelFactory: CategoryViewModelFactory
     private var catid: Int = 0


     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_english_literature)
         val loadingbar = findViewById<ProgressBar>(R.id.pbar)
         loadingbar.visibility = View.VISIBLE
         val categoryActivityHeading = findViewById<TextView>(R.id.main_category_frame_text_heading)
         val intent = intent

         // Retrieve the parameter value using the key
         val categoryCode = intent.getIntExtra("passID", -1)
         if (categoryCode == 1) {
             categoryActivityHeading.text = "English Literature"
         } else {
             categoryActivityHeading.text = "English Grammer"
         }
         val result: IntArray = when (categoryCode) {
             1 -> {
                 intArrayOf(1388, 1378, 1371, 1384, 1369, 1376, 1363)
             }

             2 -> {
                 intArrayOf(1365, 1408, 1430, 1412)
             }

             else -> intArrayOf(0)
         }


         val menubutton = findViewById<ImageView>(R.id.toggle_btn)
         val navmenu = findViewById<LinearLayout>(R.id.menu_option_sec)
         repo = PostRepo(RetrofitBuilder.getInstance())
         var categoryAdapter: CategoryAdapter
         categoryViewModelFactory = CategoryViewModelFactory(repo)
         categoryViewModel =
             ViewModelProvider(this, categoryViewModelFactory)[CategoriesViewModel::class.java]
         var numResponsesReceived = 0
         val categoryIds = result
         val listCategoryArchive: MutableList<CategoryArchive> = mutableListOf()

            // the code block is still under testing phase

             categoryViewModel.viewModelScope.launch(Dispatchers.IO) {

                 val deferredResults = categoryIds.map { categoryId ->
                     async(Dispatchers.IO) {
                         categoryViewModel.fetchCategoryArchive(categoryId, 3)
                     }
                 }
                 val results = deferredResults.awaitAll()
             }




         listCategoryArchive.clear()

         categoryViewModel.categoryArchiveTitleListLiveData.observe(this) {

             // Insert the data at the current index in listCategoryArchive
             val arch = it
             listCategoryArchive.add(arch)

             numResponsesReceived++

//            Log.i("shivam", "$numResponsesReceived  $catid $archiveTitleList ")

             if (numResponsesReceived == categoryIds.size) { // Check if all data is loaded
                 val recyclerViewCategory = findViewById<RecyclerView>(R.id.rvCategory)
                 recyclerViewCategory.layoutManager = LinearLayoutManager(this)
                 categoryAdapter = CategoryAdapter(listCategoryArchive, this)
                 recyclerViewCategory.adapter = categoryAdapter

                 // Loading bar concept

                 categoryViewModel.isLoading.observe(this) {
                     if (it) {
                         loadingbar.visibility = View.VISIBLE
                     } else {
                         loadingbar.visibility = View.INVISIBLE
                     }
                 }
             }

         }


         menubutton.setOnClickListener {
             if (navmenu.visibility == View.GONE) {
                 navmenu.visibility = View.VISIBLE
             } else {
                 navmenu.visibility = View.GONE
             }
         }

     }



    // Update adapter after all data is fetched


    // Call fetchCategoryArchive for each category ID in a background thread (optional)
    override fun onSeeAllClick(cID: Int) {
        val intent = Intent(this, PostActivity::class.java)
        Log.i("kunj", "the value in EngLit $cID")
        intent.putExtra("passID", cID)
        startActivity(intent)
    }
     fun changeCatId(para:Int){
         catid=para
     }
}


//    suspend fun getArchiveListPost(categoryId: Int) {
//
//
//    }


//        click functionalities below

//        val topic_drama = findViewById<LinearLayout>(R.id.drama_card)
//        topic_drama.setOnClickListener {
//            val intent = Intent(this, PostActivity::class.java)
//            startActivity(intent)
//        }

//        proseShowMoreText.setOnClickListener {
//            handleShowMoreClick(1376) // Pass the appropriate integer parameter for this layout
//        }
//        dramaShowMoreText.setOnClickListener {
//            handleShowMoreClick(1369) // Pass the appropriate integer parameter for this layout
//        }
//        shortstoriesShowMoreText.setOnClickListener {
//            handleShowMoreClick(1384) // Pass the appropriate integer parameter for this layout
//        }
//        novelsShowMoreText.setOnClickListener {
//            handleShowMoreClick(1371) // Pass the appropriate integer parameter for this layout
//        }
//        lit_theoryShowMoreText.setOnClickListener {
//            handleShowMoreClick(1378) // Pass the appropriate integer parameter for this layout
//        }
//        lit_criticismShowMoreText.setOnClickListener {
//
//            handleShowMoreClick(1388) // Pass the appropriate integer parameter for this layout
//        }
//        historyofenglishShowMoreText.setOnClickListener {
////            handleShowMoreClick(13) // Pass the appropriate integer parameter for this layout
//            Toast.makeText(this, "Currently Not Available", Toast.LENGTH_SHORT).show()
//        }
//        literarytermsShowMoreText.setOnClickListener {
//
////            handleShowMoreClick(13) // Pass the appropriate integer parameter for this layout
//            Toast.makeText(this, "Currently Not Available", Toast.LENGTH_SHORT).show()
//
//        }


//    private fun onShowMoreClick(parameter: Int) {
//        // Handle the click event here
//        // Start the other activity and pass the parameter
//        val intent = Intent(this, PostActivity::class.java)
//        intent.putExtra("KeyParameter", parameter)
//        startActivity(intent)
//    }
//
//    private fun handleShowMoreClick(parameter: Int) {
//        // Call the interface method to pass the parameter
//        onShowMoreClick(parameter)
//    }



