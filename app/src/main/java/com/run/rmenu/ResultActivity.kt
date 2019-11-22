package com.run.rmenu

import android.app.LauncherActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.content.IntentCompat
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_vege.*
import java.util.*

class ResultActivity : AppCompatActivity() {

    private lateinit var mRealm : Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val main = intent.getStringExtra("KEY1")
        val vege = intent.getStringExtra("KEY2")

        var food  = main + "　" + vege

        val webView = findViewById<View>(R.id.webView) as WebView
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://cookpad.com/search/" + food)

        Realm.init(this) //これいらんかも　DataApplicationは生かさなくていいのか
        mRealm = Realm.getDefaultInstance()


        //RMenuのリストには、検索ワードをいれる
        //resultActivityには、クラシルとかクックパッドとかのボタン配置して、ブラウザに飛ぶとかしても良さそう

        SaveButton.setOnClickListener {
            create(food)

            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            

        }
    }

    fun create(food :String, price: Long = 0){
        mRealm.executeTransaction{
            var Data = mRealm.createObject(Data::class.java, UUID.randomUUID().toString())
            Data.food = food
            Data.food = price.toString()

            Log.d("food", food)
            mRealm.copyToRealm(Data)
        }
    }







    override fun onDestroy() {
        super.onDestroy()
        mRealm.close()
    }
}
