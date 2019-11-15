package com.run.rmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_vege.*

class VegeActivity : AppCompatActivity() {

    var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vege)

        val array = intent.getStringArrayExtra("KEY")

        //mainDishのString型はここでkeepされている
        //val main = java.util.Arrays.toString(array)

        button.setOnClickListener {
            count += 1
            decisionButton.text = "決定"

            if(count == 1){
                textView2.text =""
                textView2.text = "キャベツ"

            }else {

                textView2.text = textView2.text.toString() + "　キャベツ"
            }
        }

        button2.setOnClickListener {
            count += 1
            decisionButton.text = "決定"

            if(count == 1){
                textView2.text =""
                textView2.text = "大根"

            }else {

                textView2.text = textView2.text.toString() + "　大根"
            }
        }

        button3.setOnClickListener {
            count += 1
            decisionButton.text = "決定"

            if(count == 1){
                textView2.text =""
                textView2.text = "白菜"

            }else {

                textView2.text = textView2.text.toString() + "　白菜"
            }
        }

        button4.setOnClickListener {
            count += 1
            decisionButton.text = "決定"

            if(count == 1){
                textView2.text =""
                textView2.text = "レタス"

            }else {

                textView2.text = textView2.text.toString() + "　レタス"
            }

        }

        button5.setOnClickListener {
            count += 1
            decisionButton.text = "決定"

            if(count == 1){
                textView2.text =""
                textView2.text = "じゃがいも"

            }else {

                textView2.text = textView2.text.toString() + "　じゃがいも"
            }

        }

        button6.setOnClickListener {
            count += 1
            decisionButton.text = "決定"

            if(count == 1){
                textView2.text =""
                textView2.text = "にんじん"

            }else {

                textView2.text = textView2.text.toString() +"　にんじん"
            }

        }

        button7.setOnClickListener {
            count += 1
            decisionButton.text = "決定"

            if(count == 1){
                textView2.text =""
                textView2.text = "ネギ"

            }else {

                textView2.text = textView2.text.toString() + "　ネギ"
            }

        }

        button8.setOnClickListener {
            count += 1
            decisionButton.text = "決定"

            if(count == 1){
                textView2.text =""
                textView2.text = "もやし"

            }else {
                textView2.text = textView2.text.toString() + "　もやし"
            }

        }

        decisionButton.setOnClickListener {
            val text1 = textView2.text.toString()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("KEY1", array)
            intent.putExtra("KEY2", text1)
            startActivity(intent)


        }

        ResetButton.setOnClickListener {
            textView2.text = ""
        }
    }



}
