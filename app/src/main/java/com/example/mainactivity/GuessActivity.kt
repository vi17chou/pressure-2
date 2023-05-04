package com.example.mainactivity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class GuessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val guess_submit=findViewById<ImageButton>(R.id.guess_submit)
        val back6 = findViewById<ImageButton>(R.id.back6)
        val number=findViewById<TextView>(R.id.number)
        val historyInput=findViewById<TextView>(R.id.history_input)
        val historyResult=findViewById<TextView>(R.id.history_result)

        val game = Game()
        game.generateAnswer();

        guess_submit.setOnClickListener {
            historyInput.setText(number.getText().toString() + "\n" + historyInput.getText());
            historyResult.setText((game.checkAnswer(number.getText().toString()))+"\n"+ historyResult.getText())
            if(game.isWin){
                // 跳出獲勝的訊息
                Toast.makeText(this, "You win", Toast.LENGTH_LONG).show();
                number.setEnabled(false);
                guess_submit.setEnabled(false);

            }
            }
        back6.setOnClickListener {
            finish()

        }
        }



    }
