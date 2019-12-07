package com.run.recommenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_emotion.*
import kotlin.random.Random

class EmotionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emotion)

        //ウキウキ
        val array = arrayOf("ハンバーグ","カレーライス","ロールキャベツ","ポトフ", "グラタン")

        //happy
        val array2 = arrayOf("ピーマン肉詰めハンバーグ","ハッシュドビーフ","酢豚","唐揚げ", "パスタ")

        //やる気ない
        val array3 = arrayOf("きつねそば","ピザトースト","おにぎり","天かすうどん", "納豆ごはん", "チキンラーメン", "卵ごはん")

        //暇
        val array4 = arrayOf("焼うどん","焼きそば","チャーハン","豚キムチ丼", "鍋", "ポトフ", "筑前煮", "煮物")


        //foodActivityのところボタンを押したら、色が変わる仕様にする


        //ウキウキ
        button.setOnClickListener {
            //ランダムな数と配列を生成して、データをresultActivityに送る
            val rI1 = Random.nextInt(5)
            val text1 = array[rI1]

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("KEY2", text1)
            startActivity(intent)
        }

        //ハッピー
        button2.setOnClickListener {
            val rI2 = Random.nextInt(5)
            val text2 = array2[rI2]

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("KEY2", text2)
            startActivity(intent)

        }


        //やる気ない
        button3.setOnClickListener {
            val rI3 = Random.nextInt(7)
            val text3 = array3[rI3]

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("KEY2", text3)
            startActivity(intent)

        }


        //暇
        button4.setOnClickListener {
            val rI4 = Random.nextInt(8)
            val text4 = array4[rI4]

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("KEY2", text4)
            startActivity(intent)
        }
    }


}
