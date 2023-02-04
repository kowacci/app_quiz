package com.example.shevchenkoignat
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    var questionNo = 0
    var questionList = listOf(
        "Вопрос викторины No 1\n\nA.Вариант 1 \n\nB. Вариант 2 \n\nC. Вариант 3",
        "Вопрос викторины No 2\n\nA.Вариант 1 \n\nB. Вариант 2 \n\nC. Вариант 3",
        "Вопрос викторины No 3\n\nA.Вариант 1 \n\nB. Вариант 2 \n\nC. Вариант 3",
        "Вопрос викторины No 4\n\nA.Вариант 1 \n\nB. Вариант 2 \n\nC. Вариант 3")
    var rightAnswer = listOf(2,3,1,1)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val questText = findViewById<TextView>(R.id.textView2)
        questText.setText(questionList[questionNo])

        val buttonA = findViewById<Button>(R.id.button2)
        val buttonB = findViewById<Button>(R.id.button5)
        val buttonC = findViewById<Button>(R.id.button6)

        buttonA.setOnClickListener {
            showToast(1, questText)
        }
        buttonB.setOnClickListener {
            showToast(2, questText)
        }
        buttonC.setOnClickListener {
            showToast(3, questText)
        }
    }

    fun showToast(answer: Int, questText: TextView) {
        if (answer == rightAnswer[questionNo]) {
            Toast.makeText(applicationContext, "ПРАВИЛЬНО!", Toast.LENGTH_SHORT).show()
            updateQ(questText)
        } else {
            Toast.makeText(applicationContext, "ОТВЕТ НЕ ВЕРНЫЙ", Toast.LENGTH_SHORT).show()
        }
    }

    fun updateQ(questText:TextView) {
        questionNo++
        if (questionNo > 3) questionNo=0
        questText.setText(questionList[questionNo])
    }


}