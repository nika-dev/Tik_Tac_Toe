package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var ResetButton:Button

    private var ActivePlayer = 1
    private var FirstPlayer = arrayListOf<Int>()
    private var SecondPlayer = arrayListOf<Int>()
    var p1Score = 0
    var p2Score = 0


    private lateinit var Fplayer:TextView
    private lateinit var Splayer:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        var player1 = intent.extras?.getString("NAME")
        var player2 = intent.extras?.getString("name")
        Fplayer = findViewById(R.id.te)
        Splayer = findViewById(R.id.t)
        if(player1.toString().isEmpty()){
            player1 = "player one"

        }
        if (player2.toString().isEmpty()){
            player2 = "player two"
        }
        Fplayer.text = player1 + "  " + p1Score.toString()
        Splayer.text = player2 + "  " + p2Score.toString()
    }
    private fun init() {
        button1 = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)
        button3 = findViewById(R.id.btn3)
        button4 = findViewById(R.id.btn4)
        button5 = findViewById(R.id.btn5)
        button6 = findViewById(R.id.btn6)
        button7 = findViewById(R.id.btn7)
        button8 = findViewById(R.id.btn8)
        button9 = findViewById(R.id.btn9)
        ResetButton = findViewById(R.id.reset)



        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        ResetButton.setOnClickListener(this)
    }
    override fun onClick(ClickedView: View?){
        if (ClickedView is Button){
            var buttonnumber = 0
            when(ClickedView.id){
                R.id.btn1 -> buttonnumber = 1
                R.id.btn2 -> buttonnumber = 2
                R.id.btn3 -> buttonnumber = 3
                R.id.btn4 -> buttonnumber = 4
                R.id.btn5 -> buttonnumber = 5
                R.id.btn6 -> buttonnumber = 6
                R.id.btn7 -> buttonnumber = 7
                R.id.btn8 -> buttonnumber = 8
                R.id.btn9 -> buttonnumber = 9
                R.id.reset -> reset()
            }
            if (buttonnumber !=0) {
                playgame(ClickedView,buttonnumber)
            }

        }
    }
     fun playgame(ClickedView: Button,buttonnumber:Int){
        if (ActivePlayer == 1 ) {
            ActivePlayer = 2
            ClickedView.text = "X"
            FirstPlayer.add(buttonnumber)
        }else if(ActivePlayer == 2){
            ActivePlayer = 1
            ClickedView.text = "O"
            SecondPlayer.add(buttonnumber)
        }
        ClickedView.isEnabled = false
        check()
         var player1 = intent.extras?.getString("NAME")
         var player2 = intent.extras?.getString("name")
         if(player1.toString().isEmpty()){
             player1 = "player one"

         }
         if (player2.toString().isEmpty()){
             player2 = "player two"
         }
         Fplayer.text = player1 + "  " + p1Score.toString()
         Splayer.text = player2 + "  " + p2Score.toString()


    }
    private fun check() {
        var winnerplayer = 0

        if (FirstPlayer.contains(1) && FirstPlayer.contains(2) && FirstPlayer.contains(3)) {
            winnerplayer = 1
        }
        if (FirstPlayer.contains(4) && FirstPlayer.contains(5) && FirstPlayer.contains(6)) {
            winnerplayer = 1
        }
        if (FirstPlayer.contains(7) && FirstPlayer.contains(8) && FirstPlayer.contains(9)) {
            winnerplayer = 1
        }
        if (FirstPlayer.contains(1) && FirstPlayer.contains(4) && FirstPlayer.contains(7)) {
            winnerplayer = 1
        }
        if (FirstPlayer.contains(2) && FirstPlayer.contains(5) && FirstPlayer.contains(8)) {
            winnerplayer = 1
        }
        if (FirstPlayer.contains(3) && FirstPlayer.contains(6) && FirstPlayer.contains(9)) {
            winnerplayer = 1
        }
        if (FirstPlayer.contains(1) && FirstPlayer.contains(5) && FirstPlayer.contains(9)) {
            winnerplayer = 1
        }
        if (FirstPlayer.contains(3) && FirstPlayer.contains(5) && FirstPlayer.contains(7)) {
            winnerplayer = 1
        }



        if (SecondPlayer.contains(1) && SecondPlayer.contains(2) && SecondPlayer.contains(3)) {
            winnerplayer = 2
        }
        if (SecondPlayer.contains(4) && SecondPlayer.contains(5) && SecondPlayer.contains(6)) {
            winnerplayer = 2
        }
        if (SecondPlayer.contains(7) && SecondPlayer.contains(8) && SecondPlayer.contains(9)) {
            winnerplayer = 2
        }
        if (SecondPlayer.contains(1) && SecondPlayer.contains(4) && SecondPlayer.contains(7)) {
            winnerplayer = 2
        }
        if (SecondPlayer.contains(2) && SecondPlayer.contains(5) && SecondPlayer.contains(8)) {
            winnerplayer = 2
        }
        if (SecondPlayer.contains(3) && SecondPlayer.contains(6) && SecondPlayer.contains(9)) {
            winnerplayer = 2
        }
        if (SecondPlayer.contains(1) && SecondPlayer.contains(5) && SecondPlayer.contains(9)) {
            winnerplayer = 2
        }
        if (SecondPlayer.contains(3) && SecondPlayer.contains(5) && SecondPlayer.contains(7)) {
            winnerplayer = 2
        }

        if (winnerplayer == 1){
            Toast.makeText(applicationContext,"Winner is FirstPlayer", Toast.LENGTH_LONG).show()
        }
        if (winnerplayer == 2){
            Toast.makeText(applicationContext,"Winner is SecondPlayer", Toast.LENGTH_LONG).show()
        }
        if (!button1.isEnabled && !button2.isEnabled && !button3.isEnabled && !button4.isEnabled && !button5.isEnabled && !button6.isEnabled && !button7.isEnabled && !button8.isEnabled && !button9.isEnabled && winnerplayer == 0){
            Toast.makeText(applicationContext,"It's a Draw", Toast.LENGTH_LONG).show()
        }
        if (winnerplayer == 1){
            p1Score = p1Score + 1
        }
        if (winnerplayer == 2){
            p2Score = p2Score + 1
        }
    }
    private fun reset(){
        FirstPlayer.clear()
        SecondPlayer.clear()
        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""

        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
        ActivePlayer = 1


    }

}
