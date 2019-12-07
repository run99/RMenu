package com.run.recommenu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import io.realm.Sort
import kotlinx.android.synthetic.main.activity_past.*

class PastActivity : AppCompatActivity() {

    private val realmConfig = RealmConfiguration.Builder()
        .deleteRealmIfMigrationNeeded()
        .build()

    private val realm: Realm by lazy {
        Realm.getInstance(realmConfig)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_past)

        val recipeList = readAll()


        val clickListener = object : ViewAdapter.OnItemClickListener {
            override fun onTrashClick(item: Recipe) {
                delete(item)
            }

            override fun onCookpadClick(item: Recipe) {
                val uri = Uri.parse("https://cookpad.com/search/" + item.food)
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }

            override fun onKurashiruClick(item: Recipe) {
                val uri = Uri.parse("https://www.kurashiru.com/search?query=" + item.food)
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)

            }

            override fun onItemClick(item: Recipe) {
                Toast.makeText(applicationContext, item.food, Toast.LENGTH_LONG).show()
            }
        }

        val adapter =
            ViewAdapter(this, recipeList, clickListener, true)

     /*   val cookpadClickListener = object : ViewAdapter.OnItemClickListener{
            override fun onItemClick(item: Recipe) {
                val uri = Uri.parse("https://cookpad.com/search/" + item.food)
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
        }

        val adapter =
            ViewAdapter(this, cookpadimage, clickListener, true)*/



        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }



    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }





    fun readAll(): RealmResults<Recipe> {
        return realm.where(Recipe::class.java).findAll().sort("date", Sort.ASCENDING)
    }

    fun deleteAll() {
        realm.executeTransaction {
            realm.deleteAll()
        }
    }

    fun delete(recipe: Recipe){
        realm.executeTransaction{
            recipe.deleteFromRealm()
        }
    }





}
