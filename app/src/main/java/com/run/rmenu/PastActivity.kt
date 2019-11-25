package com.run.rmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_past.*
import kotlinx.android.synthetic.main.item_list.*
import java.util.ArrayList

class PastActivity : AppCompatActivity() {

    //lateinit var mRealm : Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_past)

        val rv = findViewById<View>(R.id.my_recycler_view) as RecyclerView
        val adapter = ViewAdapter(this.createDataset())

        val llm = LinearLayoutManager(this)

        rv.setHasFixedSize(true)

        rv.layoutManager = llm

        rv.adapter = adapter



   /*     Realm.init(this) //これいらんかも
        mRealm = Realm.getDefaultInstance()

        val realmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(0)
            .build()
        mRealm = Realm.getInstance(realmConfiguration)
*/


    }

    private fun createDataset(): List<Data> {

        val dataset = ArrayList<Data>()
       // read()



        for (i in 0..49) {
            val data = Data().also {

                //ここを変えていきます！！！
                it.food = "カサレアル　太郎" + i + "号"
                // it.detail = "カサレアル　太郎は" + i + "個の唐揚げが好き"

            }
            dataset.add(data)
        }
        return dataset
    }


 /*  fun read() : RealmResults<Data> {
        return mRealm.where(Data::class.java).findAll()

    }*/

   /* override fun onDestroy() {
        super.onDestroy()
        mRealm.close()
    }*/


}
