package com.run.recommenu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_result.*
import java.util.*

class ResultActivity : AppCompatActivity() {

    private val realmConfig = RealmConfiguration.Builder()
        .deleteRealmIfMigrationNeeded()
        .build()

    private val realm: Realm by lazy {
        Realm.getInstance(realmConfig)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val food = intent.getStringExtra("KEY1")
        val emotion = intent.getStringExtra("KEY2")


        if(food != null){
            textView6.text = "本日の材料は"
            textView.text = "$food！"
            textView5.text = "下のボタンから調理法を調べてみてね！"
        }else{
            textView6.text = "本日の料理は"
            textView.text = "$emotion！"
            textView5.text = "下のボタンから好きな" + emotion + "を調べてみてね！"
        }


        /* if (food != null){
             val webView = findViewById<View>(R.id.webView) as WebView
             webView.webViewClient = WebViewClient()
             webView.loadUrl("https://cookpad.com/search/" + food)

         }else {
             val webView = findViewById<View>(R.id.webView) as WebView
             webView.webViewClient = WebViewClient()
             webView.loadUrl("https://cookpad.com/search/" + emotion)

         }*/


        cookpadButton.setOnClickListener {
            if (food != null) {
                val uri = Uri.parse("https://cookpad.com/search/" + food)
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            } else {
                val uri = Uri.parse("https://cookpad.com/search/" + emotion)
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
        }


        kurashiruButton.setOnClickListener {
            if (food != null) {
                val uri = Uri.parse("https://www.kurashiru.com/search?query=" + food)
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            } else {
                val uri = Uri.parse("https://www.kurashiru.com/search?query=" + emotion)
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
        }

        //RMenuのリストには、検索ワードをいれる
        SaveButton.setOnClickListener {
            if (food != null){
                create(R.drawable.happy, food)
            }else{
                create(R.drawable.buta, emotion)
            }

            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }
    }


    fun create(imageId: Int, food: String) {
        realm.executeTransaction {
            val recipe = it.createObject(Recipe::class.java, UUID.randomUUID().toString())
            recipe.imageId = imageId
            recipe.food = food
            recipe.date = Date(System.currentTimeMillis())
            realm.copyToRealm(recipe)
        }
    }
    /* fun create(food :String, price: Long = 0){
         mRealm.executeTransaction{
             var Recipe = mRealm.createObject(Recipe::class.java, UUID.randomUUID().toString())
             Recipe.food = food
             Recipe.food = price.toString()

             Log.d("food", food)
             mRealm.copyToRealm(Recipe)
         }
     }*/


    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}
