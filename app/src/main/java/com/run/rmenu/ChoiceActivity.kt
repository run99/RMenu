package com.run.rmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choice.*

class ChoiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        food_button.setOnClickListener {
            val intent: Intent = Intent(this, FoodActivity::class.java)
            startActivity(intent)
        }


        emotion_button.setOnClickListener {
            val intent: Intent = Intent(this, EmotionActivity::class.java)
            startActivity(intent)
        }
    }
}
