package com.aristotele.trivia2022.game

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import androidx.core.graphics.green
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.aristotele.trivia2022.R
import com.aristotele.trivia2022.title.TitleFragmentDirections
import kotlin.properties.Delegates

class GameViewModel : ViewModel() {


    data class Question (
        val text:String,
        val answers:List<String>
            )

    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "What is Android Jetpack?",
            answers = listOf("♥all of these", "tools", "documentation", "libraries")),
        Question(text = "Base class for Layout?",
            answers = listOf("♥ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")),
        Question(text = "Layout for complex Screens?",
            answers = listOf("♥ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")),
        Question(text = "Pushing structured data into a Layout?",
            answers = listOf("♥Data Binding", "Data Pushing", "Set Text", "OnClick")),
        Question(text = "Inflate layout in fragments?",
            answers = listOf("♥onCreateView", "onViewCreated", "onCreateLayout", "onInflateLayout")),
        Question(text = "Build system for Android?",
            answers = listOf("♥Gradle", "Graddle", "Grodle", "Groyle")),
        Question(text = "Android vector format?",
            answers = listOf("♥VectorDrawable", "AndroidVectorDrawable", "DrawableVector", "AndroidVector")),
        Question(text = "Android Navigation Component?",
            answers = listOf("♥NavController", "NavCentral", "NavMaster", "NavSwitcher")),
        Question(text = "Registers app with launcher?",
            answers = listOf("♥intent-filter", "app-registry", "launcher-registry", "app-launcher")),
        Question(text = "Mark a layout for Data Binding?",
            answers = listOf("♥<layout>", "<binding>", "<data-binding>", "<dbinding>"))
    )




    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>

     var  javab :String
     var  EntekhabKarbar :String
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
// ============================   بخش مربوط به کلمه ها
//   بسیار دقت کنید که این اینت برمیگردونه و در xml تکس قراره نشون بدیم
//    اومدیم در xml یه استرینگ تعریف کردیم که اینت بگیره با %d برید تو بخش استرینگ ها ببینید
// وگرنه خطا میده میگه پیشنهاد میکنیم از لایف سایکل و ... استفاده کنید
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score
//    val currentScore = Transformations.map(score) {
//       it
//    }
//
//    private val _background = MutableLiveData<ColorDrawable>()
//    val background: LiveData<ColorDrawable>
//    get() = _background


    //

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    //    ------------------------------------------------------------------------------------
    //ساخت شبیه ساز اونت همیشه به این صورته که یه بولین داریم همیشه و یه متد فانکشن برای برگردوندن به فالس
    // مقدار رو همیشه بعد صدا کردن متد باید فالس کنیم تا به حالت اولیه برگرده
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    /** Methods for completed events **/
    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////



    private val _questionTexet= MutableLiveData<String>()
    val questionTexet : LiveData<String>
        get() = _questionTexet

    private val _radioButton1= MutableLiveData<String>()
    val radioButton1 : LiveData<String>
        get() = _radioButton1

    private val _radioButton2= MutableLiveData<String>()
    val radioButton2 : LiveData<String>
        get() = _radioButton2

    private val _radioButton3= MutableLiveData<String>()
    val radioButton3 : LiveData<String>
        get() = _radioButton3

    private val _radioButton4= MutableLiveData<String>()
    val radioButton4 : LiveData<String>
        get() = _radioButton4



    init {
    // Shuffles the questions and sets the question index to the first question.
        _score.value=0
        javab="---"
        EntekhabKarbar=""
       // _background.value= ColorDrawable(R.color.white)
        randomizeQuestions()
    }


    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        setQuestion()
    }


    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {

        //currentQuestion = questions[0]
        currentQuestion=questions.removeFirst() //این اولی رو میگیره برمیگردونه و پاکش میکنه
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        javab=answers[0]
        // and shuffle them
        answers.shuffle()

        _questionTexet.value=currentQuestion.text
        _radioButton1.value=answers[0]
        _radioButton2.value=answers[1]
        _radioButton3.value=answers[2]
        _radioButton4.value=answers[3]
    }



    fun buttonOnClickListener() {

//Log.i("arastoo","dddd${questions.size}")


        if (questions.isEmpty()) {
            Log.i("arastoo", "سوالا تموم شد برو صفحه بعد")
            _eventGameFinish.value = true


        } else {
            Log.i("arastoo", "javab=$javab ==> EntekhabKarbar==$EntekhabKarbar")

            if(javab===EntekhabKarbar){
                _score.value = _score.value?.plus(1)
               // _background.value=ColorDrawable(R.color.bluo)
                Log.i("arastoo","xxx=>${_score.value}")
            }
            else{
                _score.value = (_score.value)?.minus(1)
                Log.i("arastoo","xxx=>${_score.value}")
               // _background.value=ColorDrawable(R.color.red)
            }



            //questionIndex+1
            randomizeQuestions()
        }
    }


//این فانکشنی هست که میگیم وقتی رو رادیو باتن کلیک شد اجرا بشه

    fun selectOption(radioGroup: RadioGroup, radioButton: View)
    {
        Log.i("arastoo","tag==> ${radioButton.tag}")

        EntekhabKarbar=radioButton.tag.toString()
        Log.i("arastoo","EntekhabKarbar==> ${EntekhabKarbar}")
       // radioGroup.check(radioButton.id)
        //radioButton.tooltipText
    }


}