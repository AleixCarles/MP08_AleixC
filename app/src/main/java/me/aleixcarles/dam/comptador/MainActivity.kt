package me.aleixcarles.dam.comptador

import android.annotation.SuppressLint
import android.content.IntentSender.OnFinished
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val INITIAL_TIME = 3

    internal lateinit var tapMeBottom : Button
    internal lateinit var timeTextView : TextView
    internal lateinit var counterTextView : TextView
    internal var counter = 0
    internal var time = INITIAL_TIME

    internal var appStarted = false
    internal lateinit var countdownTimer : CountDownTimer
//    internal val initialCountDownTimer: Long = 60000
    internal val initialCountDownTimer: Long = time.toLong()*1000
    internal val intervalCountDownTimer: Long = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCountdown()

        tapMeBottom = findViewById(R.id.tapMeBottom)
        timeTextView = findViewById(R.id.timeTextView)
        counterTextView = findViewById(R.id.counterTextView)

        tapMeBottom.setOnClickListener {
            if (!appStarted){
                startGame()

            }
            incrementCounter()
        }
        timeTextView.text = getString(R.string.timeText, time)
    }

    private fun startGame() {
        countdownTimer.start()
        appStarted = true
    }

    private fun initCountdown(){
        countdownTimer = object : CountDownTimer(initialCountDownTimer,intervalCountDownTimer){
            override fun onTick(millisUntilFinished: Long) {
                    val timeLeft = millisUntilFinished / 1000
                    timeTextView.text = timeLeft.toString()
            }

            override fun onFinish() {
                endGame()
            }
        }
    }


    private fun incrementCounter() {
//        counter = counter+1
        counter += 1
        counterTextView.text = counter.toString()
    }
    private fun endGame() {
        Toast.makeText(this,getString(R.string.endGame, counter), Toast.LENGTH_LONG).show()
        resetGame()
    }
    private fun resetGame(){
        counter = 0
        counterTextView.text = counter.toString()
        timeTextView = findViewById(R.id.timeTextView)
        time = INITIAL_TIME
        timeTextView.text = time.toString()
        initCountdown()
        appStarted = false

    }
}