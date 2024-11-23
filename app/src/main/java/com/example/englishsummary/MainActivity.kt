package com.example.englishsummary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var quizViewModel: QuizViewModel
    private lateinit var qrepo: QuizRepo
    private lateinit var quizViewModelFactory: QuizViewModelFactory
    private lateinit var quizdata: MutableList<QuizItem>
    private lateinit var quizQuestionText: TextView
    private var currentQuizIndex = 0
    private lateinit var radioGroup :RadioGroup
    private lateinit var radioBtn1: RadioButton
    private lateinit var radioBtn2: RadioButton
    private lateinit var radioBtn3: RadioButton
    private lateinit var radioBtn4: RadioButton
    private lateinit var nextBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize quizdata as an empty mutable list
        quizdata = mutableListOf()

        // Initialize views
        initViews()

        nextBtn.setOnClickListener {

            // Move to the next question
            var total_question =quizdata.size
            currentQuizIndex++
            currentQuizIndex =currentQuizIndex%total_question



                // Set the next question
                setQuiz(currentQuizIndex)
                // Reset background tint for options
                resetOptionBackgrounds()
                radioGroup.clearCheck()



        }

        // Initialize ViewModel and fetch quiz details
        setupViewModel()
        fetchQuizDetails()
    }

    private fun setupViewModel() {
        qrepo = QuizRepo(QuizRetrofitBuilder.getInstance())
        quizViewModelFactory = QuizViewModelFactory(qrepo)
        quizViewModel = ViewModelProvider(this, quizViewModelFactory)[QuizViewModel::class.java]
    }

    private fun fetchQuizDetails() {
        quizViewModel.viewModelScope.launch(Dispatchers.IO) {
            try {
                quizViewModel.fetchQuizDetail()
                Log.i("mylogmsg", "Calling Successful")
            } catch (e: Exception) {
                Log.e("mylogmsg", "Error fetching quiz details", e)
            }
        }

        quizViewModel.quizLiveData.observe(this) { listOfQuizData ->
            quizdata.clear()
            quizdata.addAll(listOfQuizData)
            // Set the first quiz question only after quizdata is populated
            if (quizdata.isNotEmpty()) {
                setQuiz(currentQuizIndex)
            } else {
                Toast.makeText(this, "Error in The Server", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setQuiz(currentQuizIndex: Int) {
        val currentQuiz = quizdata[currentQuizIndex]
        quizQuestionText.text = currentQuiz.question.text

        // Combine correct and incorrect answers
        val allOptions = mutableListOf<String>()
        allOptions.add(currentQuiz.correctAnswer)
        allOptions.addAll(currentQuiz.incorrectAnswers)
        // Shuffle the options
        allOptions.shuffle()

        // Set options to radio buttons
        radioBtn1.text = allOptions[0]
        radioBtn2.text = allOptions[1]
        radioBtn3.text = allOptions[2]
        radioBtn4.text = allOptions[3]

        // Set click listeners for options
        setOptionClickListener(radioBtn1, currentQuiz.correctAnswer)
        setOptionClickListener(radioBtn2, currentQuiz.correctAnswer)
        setOptionClickListener(radioBtn3, currentQuiz.correctAnswer)
        setOptionClickListener(radioBtn4, currentQuiz.correctAnswer)

        // Hide the next button initially
        nextBtn.visibility = View.GONE


    }

    private fun initViews() {
        val navMenu = findViewById<LinearLayout>(R.id.menu_option_sec)
        val menuButton = findViewById<ImageView>(R.id.toggle_btn)
        val menuOptionHome = findViewById<TextView>(R.id.menu_option_home)
        val menuOptionEngLit = findViewById<TextView>(R.id.menu_option_englit)
        val menuOptionEngGram = findViewById<TextView>(R.id.menu_option_enggram)
        val menuOptionIndianBoards = findViewById<TextView>(R.id.menu_option_indianboards)
        val menuOptionInteractive = findViewById<TextView>(R.id.menu_option_interactive)
        val cardEngLit = findViewById<LinearLayout>(R.id.thumbnail_englit)
        val cardEngGram = findViewById<LinearLayout>(R.id.thumbnail_enggram)
        val cardIndianBoards = findViewById<LinearLayout>(R.id.thumbnail_indianboards)
        val cardInteractive = findViewById<LinearLayout>(R.id.thumbnail_interactive)
        quizQuestionText = findViewById(R.id.quiz_question)

        radioGroup =findViewById<RadioGroup>(R.id.optionsRadioGroup)
        radioBtn1 = findViewById<RadioButton>(R.id.option1RadioButton)
        radioBtn2 = findViewById<RadioButton>(R.id.option2RadioButton)
        radioBtn3 = findViewById<RadioButton>(R.id.option3RadioButton)
        radioBtn4 = findViewById<RadioButton>(R.id.option4RadioButton)
        nextBtn = findViewById<Button>(R.id.next_question_button)

        menuButton.setOnClickListener {
            navMenu.visibility = if (navMenu.visibility == View.GONE) View.VISIBLE else View.GONE
        }

        menuOptionEngLit.setOnClickListener {
            navigateToCategory(1)
        }

        menuOptionEngGram.setOnClickListener {
            navigateToCategory(2)
        }

        menuOptionIndianBoards.setOnClickListener {
            navigateToCategory(3)
        }

        cardEngLit.setOnClickListener {
            navigateToCategory(1)
        }

        cardEngGram.setOnClickListener {
            navigateToCategory(2)
        }

        cardIndianBoards.setOnClickListener {
            navigateToCategory(3)
        }
    }

    private fun setOptionClickListener(radioButtonView: RadioButton, correctAnswer: String) {
        radioButtonView.setOnClickListener {
            val selectedOption = radioButtonView.text.toString()
            if (selectedOption == correctAnswer) {
                radioButtonView.setBackgroundColor(resources.getColor(R.color.green))
            } else {
                radioButtonView.setBackgroundColor(resources.getColor(R.color.red))
                highlightCorrectOption(correctAnswer)
            }
            disableOptionClickListeners()
            nextBtn.visibility = View.VISIBLE
        }
    }

    private fun disableOptionClickListeners() {
        radioBtn1.isClickable = false
        radioBtn2.isClickable = false
        radioBtn3.isClickable = false
        radioBtn4.isClickable = false
    }

    private fun highlightCorrectOption(correctAnswer: String) {
        val rBViews = listOf(radioBtn1, radioBtn2, radioBtn3, radioBtn4)
        for (rBView in rBViews) {
            if (rBView.text.toString() == correctAnswer) {
                rBView.setBackgroundColor(resources.getColor(R.color.green))
            }
        }
    }

    private fun navigateToCategory(categoryCode: Int) {
        val intent = Intent(this, EnglishLiteratureActivity::class.java)
        intent.putExtra("passID", categoryCode)
        startActivity(intent)
    }

//    private fun setQuestion(questionIndex: Int) {
//        val currentQuestion = quizdata[questionIndex]
//        quizQuestionText.text = currentQuestion.question.text
//        val allOptions = mutableListOf<String>()
//        allOptions.add(currentQuestion.correctAnswer)
//        allOptions.addAll(currentQuestion.incorrectAnswers)
//        // Shuffle the options
//        allOptions.shuffle()
//
//        // Set options to radio buttons
//        radioBtn1.text = allOptions[0]
//        radioBtn2.text = allOptions[1]
//        radioBtn3.text = allOptions[2]
//        radioBtn4.text = allOptions[3]
//
//        // Set click listeners for options
//        setOptionClickListener(radioBtn1, currentQuestion.correctAnswer)
//        setOptionClickListener(radioBtn2, currentQuestion.correctAnswer)
//        setOptionClickListener(radioBtn3, currentQuestion.correctAnswer)
//        setOptionClickListener(radioBtn4, currentQuestion.correctAnswer)
//
//        // Hide the next button initially
//        nextBtn.visibility = View.GONE
//    }

    private fun resetOptionBackgrounds() {
        val optionTextViews = listOf(radioBtn1, radioBtn2, radioBtn3, radioBtn4)
        for (optionTextView in optionTextViews) {
            optionTextView.setBackgroundColor(Color.White.hashCode())
        }
    }

}
