package com.run.rmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_vege.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val array = intent.getStringArrayExtra("KEY1")
        val main = java.util.Arrays.toString(array)


        val vege = intent.getStringExtra("KEY2")

        if(main.length == 0){
            textView.text = main[0].toString() + " " + vege

        }else if(main.length == 1){
            textView.text = main[0].toString() + " " + main[1].toString() + " "+ vege

        }else{
            textView.text = main
        }

        textView2.text = vege



    }
}
