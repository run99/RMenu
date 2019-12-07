package com.run.recommenu

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_vege.*


class VegeActivity : AppCompatActivity() {

    var count : Int = 0
    var count2 : Int = 0
    var count3 : Int = 0
    var count4 : Int = 0
    var count5 : Int = 0
    var count6 : Int = 0
    var count7 : Int = 0
    var count8 : Int = 0

    var text = ""
    var text2 = ""
    var text3 = ""
    var text4 = ""
    var text5 = ""
    var text6 = ""
    var text7 = ""
    var text8 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vege)

        val array = intent.getStringExtra("KEY")

        //mainDishのString型はここでkeepされている
        //val main = java.util.Arrays.(array)

        button.setOnClickListener {
            count += 1
            decisionButton.text = "決定"



            when{
                count % 2 == 0 ->{
                    button.setBackgroundColor(Color.rgb(204,204,204))
                    text = ""
                }
                count % 2 == 1 ->{
                    button.setBackgroundColor(Color.rgb(255,140,0))
                    text = "キャベツ"
                }
            }


           /* if(count == 1){
                text1 =""
                text1 = "キャベツ"

            }else {

                text1 = text1 + "　キャベツ"
            }*/
        }

        button2.setOnClickListener {
            count2 += 1
            decisionButton.text = "決定"

            when{
                count2 %2 == 0 ->{
                    button2.setBackgroundColor(Color.rgb(204,204,204))
                    text2 = ""
                }
                count2 %2 == 1 ->{
                    button2.setBackgroundColor(Color.rgb(255,140,0))
                    text2 = "大根"
                }
            }

           /* if(count2 == 1){
                text1 =""
                text1 = "大根"

            }else {

                text1 = text1 + "　大根"
            }*/
        }

        button3.setOnClickListener {
            count3 += 1
            decisionButton.text = "決定"

            when{
                count3%2 == 0 ->{
                    button3.setBackgroundColor(Color.rgb(204,204,204))
                    text3 = ""

                }
                count3%2 == 1 ->{
                    button3.setBackgroundColor(Color.rgb(255,140,0))
                    text3 = "白菜"
                }
            }

           /* if(count3 == 1){
                text1 =""
                text1 = "白菜"

            }else {

                text1 = text1 + "　白菜"
            }*/
        }

        button4.setOnClickListener {
            count4 += 1
            decisionButton.text = "決定"

            when{
                count4%2 == 0 ->{
                    button4.setBackgroundColor(Color.rgb(204,204,204))
                    text4 = ""
                }
                count4%2 == 1 ->{
                    button4.setBackgroundColor(Color.rgb(255,140,0))
                    text4 = "レタス"
                }
            }

           /*if(count4 == 1){
                text1 =""
                text1 = "レタス"

            }else {

                text1 = text1 + "　レタス"
            }*/

        }

        button5.setOnClickListener {
            count5 += 1
            decisionButton.text = "決定"

            when{
                count5%2 == 0 ->{
                    button5.setBackgroundColor(Color.rgb(204,204,204))
                    text5 = ""
                }
                count5%2 == 1 ->{
                    button5.setBackgroundColor(Color.rgb(255,140,0))
                    text5 = "じゃがいも"
                }
            }

            /*if(count5 == 1){
                text1 =""
                text1 = "じゃがいも"

            }else {

                text1 = text1 + "　じゃがいも"
            }*/

        }

        button6.setOnClickListener {
            count6 += 1
            decisionButton.text = "決定"


            when{
                count6%2 == 0 ->{
                    button6.setBackgroundColor(Color.rgb(204,204,204))
                    text6 = ""
                }
                count6%2 == 1 ->{
                    button6.setBackgroundColor(Color.rgb(255,140,0))
                    text6 = "にんじん"
                }
            }

            /*if(count6 == 1){
                text1 =""
                text1 = "にんじん"

            }else {

                text1 = text1 +"　にんじん"
            }*/

        }

        button7.setOnClickListener {
            count7 += 1
            decisionButton.text = "決定"

            when{
                count7%2 == 0 ->{
                    button7.setBackgroundColor(Color.rgb(204,204,204))
                    text7 = ""
                }
                count7%2 == 1 ->{
                    button7.setBackgroundColor(Color.rgb(255,140,0))
                    text7 = "ネギ"
                }
            }

           /* if(count7 == 1){
                text1 =""
                text1 = "ネギ"

            }else {

                text1 = text1 + "　ネギ"
            }*/

        }

        button8.setOnClickListener {
            count8 += 1
            decisionButton.text = "決定"

            when{
                count8%2 == 0 ->{
                    button8.setBackgroundColor(Color.rgb(204,204,204))
                    text8 = ""
                }
                count8%2 == 1 ->{
                    button8.setBackgroundColor(Color.rgb(255,140,0))
                    text8 = "もやし"


                }
            }



            /*if(count8 == 1){
                text1 =""
                text1 = "もやし"

            }else {
                text1 = text1 + "　もやし"
            }*/

        }

        decisionButton.setOnClickListener {


            val textFinal =  text + " " + text2 + " " + text3 + " " + text4 +
                    " " + text5 +" "+ text6 + " " + text7 + " " + text8

            Log.d("food", textFinal)

            val food = "$array $textFinal"

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("KEY1", food)
            startActivity(intent)

        }
        
    }

}
