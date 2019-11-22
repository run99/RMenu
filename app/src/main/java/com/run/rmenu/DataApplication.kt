package com.run.rmenu

import android.app.Application

import io.realm.Realm

open class DataApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
    }
}
