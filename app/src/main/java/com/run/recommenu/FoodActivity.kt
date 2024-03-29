package com.run.recommenu

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food.*

class FoodActivity : AppCompatActivity() {


    var A : Int = 0
    var B : Int = 0
    var C : Int = 0


    //listOf(listOfを生成させる
    val list = listOf(
        listOf("牛","豚", "鳥"),
        listOf("焼魚","生魚","どっちでも"),
        listOf("ご飯","麺","どっちでも"),
        listOf("キャベツ","大根","skip"),
        listOf("白菜","レタス","skip"),
        listOf("じゃがいも","にんじん","skip"),
        listOf("ねぎ","もやし","skip"))


    val questions = listOf(
        "Q2 好きなものを選んでね",
        "Q3 主食を選んでね",
        "Q4 冷蔵庫に余っている野菜を選んでね",
        "Q4 冷蔵庫に余っている野菜を選んでね",
        "Q4 冷蔵庫に余っている野菜を選んでね",
        "Q4 冷蔵庫に余っている野菜を選んでね"
    )




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        textView.text = "Q1　主菜を選んでね"
        textView.setTextColor(Color.rgb(0,0,0))

        button.text = "肉"
        button.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.niku,0,0)
        button2.text = "魚"
        button2.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.fish,0,0)
        button3.text = "どっちでも"
       // button3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.niku, 0,R.drawable.fish,0)





        button.setOnClickListener {

            A+= 1

            if(A == 1 && B == 0&& C == 0) {
                textView.text = questions[0]
                textView.setTextColor(Color.rgb(0,0,0))

                button.text = list[0][0]
                button.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.ushi,0,0)

                button2.text = list[0][1]
                button2.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.buta,0,0)

                button3.text = list[0][2]
                button3.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.tori,0,0)

            }else if(A == 2 && B == 0 && C == 0){
                stapleMethod()

            }else if(A == 3 && B == 0 && C == 0){
                val array = list[0][0] +"　"+  list[2][0] // 牛、ご飯

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 2 && B == 1 && C == 0){
                val array = list[0][1] + "　" +  list[2][0] //豚、ご飯

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 2 && B == 0 && C == 1){
                val array = list[0][2] +  "　" +  list[2][0] //鳥、ご飯

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 1 && B == 1&& C == 0){
                stapleMethod()

            }else if(A == 2 && B == 1 && C == 0){
                val array = list[1][0]+"　"+ list[2][0] //焼き魚、ご飯

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 1 && B == 2 && C == 0){
                val array =  list[1][1] +  list[2][0] //生魚、ご飯

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 1 && B ==1 && C == 1){
                val array = "魚"+ "　" +  list[2][0]  //魚、ご飯

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else{
                val array = "米"

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)
            }


        }

        button2.setOnClickListener {

            B+= 1

            if(A == 0 && B == 1 && C == 0){
                textView.text = questions[0] //好きなもの
                textView.setTextColor(Color.rgb(0,0,0))

                button.text = list[1][0] //焼
                button.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.yakisakana,0,0)


                button2.text = list[1][1] //生
                button2.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.sashimi,0,0)


                button3.text = list[1][2] //魚
                button3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.fish,0,0)


            }else if(A == 1 && B == 1 && C == 0){
                stapleMethod()

            }else if(A == 0 && B == 2 && C == 0){
                stapleMethod()

            }else if(A == 2 && B == 1 && C == 0){
                val array = list[0][0] + "　" +  list[2][1] //牛、麺

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 1 && B == 2 && C == 0){
                val array = list[0][1] + "　" +  list[2][1] //豚、麺

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 1 && B == 1 && C == 1){
                val array = list[0][2] + "　" +  list[2][1] //鳥、麺

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 1 && B == 2 && C == 0){
                val array = list[1][0] + "　" +  list[2][1] //焼魚、麺

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 0 && B == 3 && C == 0){
                val array = list[1][1] + "　" +  list[2][1] //生魚、麺

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 0 && B == 2 && C == 1){
                val array = "魚" + "　"  + list[2][1] //魚、麺

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else{
                val array = list[2][1] //麺

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)
            }


        }

        button3.setOnClickListener {

            C+= 1

            if(A == 0 && B == 0 && C == 1){
                stapleMethod()

            }else if(A == 1 && B == 0 && C == 1){
                stapleMethod()

            }else if(A == 0 && B == 1 && C == 1){
                stapleMethod()

            }else if(A == 2 && B == 0 && C == 1) {
                val array = list[0][0] //牛

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 1 && B == 1 && C == 1) {
                val array = list[0][1] //豚

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 1 && B == 0 && C == 2) {
                val array = list[0][2] //鳥

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 1 && B == 1 && C == 1) {
                val array = list[1][0] //焼き魚

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 0 && B == 2 && C == 1) {
                val array = list[1][1] //生魚

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else if(A == 0 && B == 1 && C == 2){
                val array = "魚"

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)

            }else{
                val array = "　"

                val intent = Intent(this, VegeActivity::class.java)
                intent.putExtra("KEY", array)
                startActivity(intent)
            }
        }
    }



    fun stapleMethod(){
        textView.text = questions[1] //主食
        textView.setTextColor(Color.rgb(0,0,0))

        button.text = list[2][0] //米
        button.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.hakumai,0,0)

        button2.text = list[2][1] //麺
        button2.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.udon,0,0)

        button3.text = list[2][2] //どっちでも
       // button3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.hakumai,0,R.drawable.udon,0)
        button3.setBackgroundColor(Color.rgb(204,204,204))
        button3.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
    }
}
