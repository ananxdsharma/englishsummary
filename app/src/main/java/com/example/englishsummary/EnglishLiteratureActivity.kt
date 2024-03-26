package com.example.englishsummary


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EnglishLiteratureActivity : AppCompatActivity() {

    private lateinit var categoryViewModel: CategoriesViewModel
    private lateinit var repo: PostRepo
    private lateinit var categoryViewModelFactory: CategoryViewModelFactory
    private var categoryAdapter = CategoryAdapter(mutableListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english_literature)


        val menubutton = findViewById<ImageView>(R.id.toggle_btn)
        val navmenu = findViewById<LinearLayout>(R.id.menu_option_sec)


        repo = PostRepo(RetrofitBuilder.getInstance())
        categoryViewModelFactory = CategoryViewModelFactory(repo)
        categoryViewModel =
            ViewModelProvider(this, categoryViewModelFactory)[CategoriesViewModel::class.java]
        var numResponsesReceived = 0
        val categoryIds = intArrayOf(1388, 1378, 1371, 1384, 1369, 1376, 1363)
        val listCategoryArchive: MutableList<CategoryArchive> = MutableList(categoryIds.size) {
            CategoryArchive(0, "", "", "") }
        listCategoryArchive.clear()
        var currentIndex = 0 // Initialize currentIndex to track the current index in listCategoryArchive

        for (categoryId in categoryIds) {
            categoryViewModel.viewModelScope.launch(Dispatchers.IO) {
                categoryViewModel.fetchCategoryArchive(categoryId, 3)
            }
        }

        categoryViewModel.categoryLiveData.observe(this) {
            if (it.isNotEmpty()) {
                val catid: Int = categoryViewModel.cID
                val title1 = it[0].title.rendered.toString()
                val title2 = it[1].title.rendered.toString()
                val title3 = it[2].title.rendered.toString()

                val archiveTitleList = CategoryArchive(catid, title1, title2, title3)

                // Insert the data at the current index in listCategoryArchive
                listCategoryArchive.add(archiveTitleList)

                numResponsesReceived++
                currentIndex++ // Increment currentIndex to prepare for the next insertion
            }


            // Update adapter after all data is fetched
            if (numResponsesReceived == categoryIds.size) { // Check if all data is loaded
                val recyclerViewCategory = findViewById<RecyclerView>(R.id.rvCategory)
                recyclerViewCategory.layoutManager = LinearLayoutManager(this)
                val categoryAdapter = CategoryAdapter(listCategoryArchive)
                recyclerViewCategory.adapter = categoryAdapter
            }
        }

// Call fetchCategoryArchive for each category ID in a background thread (optional)

        menubutton.setOnClickListener {
            if (navmenu.visibility == View.GONE) {
                navmenu.visibility = View.VISIBLE
            } else {
                navmenu.visibility = View.GONE
            }
        }
    }


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


//    override fun onShowMoreClick(parameter: Int) {
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


}
