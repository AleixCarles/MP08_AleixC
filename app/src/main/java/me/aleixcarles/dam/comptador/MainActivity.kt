package me.aleixcarles.dam.comptador

import android.content.IntentSender.OnFinished
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    internal lateinit var tapMeBottom : Button
    internal lateinit var timeTextView : TextView
    internal lateinit var counterTextView : TextView
    internal var counter = 0
    internal var time = 60

    internal var appStarted = false
    internal lateinit var countdownTimer : CountDownTimer
    internal val initialCountDownTimer: Long = 60000
    internal val intervalCountDownTimer: Long = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCountdown()

        tapMeBottom = findViewById(R.id.tapMeBottom)
        timeTextView = findViewById(R.id.timeTextView)
        counterTextView = findViewById(R.id.counterTextView)
    // Actualitzar o definir valor inicial de  counterTextView ->  counterTextView = score -> 0
    //TODO en algun moment harem d'executa icrementCounter
        tapMeBottom.setOnClickListener {
            if (!appStarted){
                startGame()

            }
            incrementCounter()
        }
//        timeTextView.text = time.toString()
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
                TODO("Not yet implemented")
            }
        }
    }


    private fun incrementCounter() {
//        counter = counter+1
        counter += 1
        counterTextView.text = counter.toString()

    }
    private fun endGame() {
        Toast.makeText(this,getString(R.string.))
    }
}