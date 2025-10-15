package com.example.examencarlodavilaunidadi

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import java.util.Timer
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var rondasg : TextView
    var rondas = 0
    private val PREFS = "Highscore"
    lateinit var empezar : Button
    lateinit var surrender : Button
    lateinit var textoSimon : EditText
    lateinit var colRojo : LinearLayout
    lateinit var colVerde : LinearLayout
    lateinit var colAzul : LinearLayout
    lateinit var colAmarillo : LinearLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val segundos = millisUntilFinished / 1000
                colAzul.apply { segundos }
                colRojo.apply { segundos }
                colVerde.apply { segundos }
                colAmarillo.apply { segundos }
            }

            override fun onFinish() {
                val colornvo=Color.rgb(135,206,235)
                colAzul.setBackgroundColor(colornvo)
                val colornvo22=Color.rgb(	50,205,50)
                colVerde.setBackgroundColor(colornvo22)
                val colornvo1=Color.rgb(220,20,60)
                colRojo.setBackgroundColor(colornvo1)
                val colornvo4=Color.rgb(255,248,220)
                colAmarillo.setBackgroundColor(colornvo4)
            }
        }
        timer.start()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rondasg=findViewById(R.id.Highscore)
        val preferencias = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        colRojo = findViewById(R.id.Crojo)
        colVerde = findViewById(R.id.Cverde)
        colAzul = findViewById(R.id.Cazul)
        colAmarillo = findViewById(R.id.Camarillo)
        empezar = findViewById(R.id.btnIniciar)
        surrender = findViewById(R.id.btnRendirse)
        textoSimon = findViewById<EditText>(R.id.editText)
        colRojo.setOnClickListener{
            val colornvo=Color.rgb(220,20,60)
            colRojo.setBackgroundColor(colornvo)
        }
        colVerde.setOnClickListener {
            val colornvo=Color.rgb(	50,205,50)
            colVerde.setBackgroundColor(colornvo)
        }
        colAzul.setOnClickListener {
            val colornvo=Color.rgb(135,206,235)
            colAzul.setBackgroundColor(colornvo)
        }
        colAmarillo.setOnClickListener {
            val colornvo=Color.rgb(255,248,220)
            colAmarillo.setBackgroundColor(colornvo)
        }
        empezar.setOnClickListener {
            iniciarJuego()
        }
        surrender.setOnClickListener {
            reiniciarJ()
            Bloquearly()
        }
    }

     fun iniciarJuego(){
        val texto="Partida iniciada"
        textoSimon.setText(texto)
        textoSimon.isEnabled=false
        surrender.isEnabled=true
        colRojo.isEnabled=true
        colVerde.isEnabled=true
        colAmarillo.isEnabled=true
        colAzul.isEnabled=true
         empezar.isEnabled=false
         rondasg.setText("")
         rondas=0
    }
     fun reiniciarJ() {
        Toast.makeText(this, "El usuario se ha rendido, juego reiniciado", Toast.LENGTH_SHORT).show()
         empezar.isEnabled=true
         surrender.isEnabled=true
         val colorr=Color.rgb(191, 17, 17)
         colRojo.setBackgroundColor(colorr)
         val colorv=Color.rgb(26, 222, 39)
         colVerde.setBackgroundColor(colorv)
         val colora=Color.rgb(253, 253, 25)
         colAmarillo.setBackgroundColor(colora)
         val colorA=Color.rgb(41, 65, 222)
         colAzul.setBackgroundColor(colorA)
         nrondas()
    }
     fun Bloquearly(){
         textoSimon.isEnabled=false
            colRojo.isEnabled = false
            colVerde.isEnabled = false
            colAmarillo.isEnabled = false
            colAzul.isEnabled = false
        }
    fun BloquearS(){
        surrender.isEnabled=false
    }
    fun nrondas(){
        rondas++
        val ronda="Felicidades, has durado: $rondas"
        rondasg.setText(ronda)
    }
}
