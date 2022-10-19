package me.aleixcarles.dam.comptador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    internal lateinit var tapMeBottom : Button
    internal lateinit var timeTextView : TextView
    internal lateinit var counterTextView : TextView
    internal var counter = 0
    internal var time = 60

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tapMeBottom = findViewById(R.id.tapMeBottom)
        timeTextView = findViewById(R.id.timeTextView)
        counterTextView = findViewById(R.id.counterTextView)
    // Actualitzar o definir valor inicial de  counterTextView ->  counterTextView = score -> 0
    //TODO en algun moment harem d'executa icrementCounter
        tapMeBottom.setOnClickListener {
            incrementCounter()
        }
//        timeTextView.text = time.toString()
        timeTextView.text = getString(R.string.timeText, time)
    }
    private fun incrementCounter() {
//        counter = counter+1
        counter += 1
        counterTextView.text = counter.toString()

    }
}