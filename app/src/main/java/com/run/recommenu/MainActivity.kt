package com.run.recommenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todayMenu_button.setOnClickListener {
            val intent : Intent = Intent(this, ChoiceActivity::class.java)
            startActivity(intent)
        }

        pastMenu_button.setOnClickListener {
            val intent : Intent = Intent(this, PastActivity::class.java)
            startActivity(intent)
        }
    }
}
