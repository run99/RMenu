package com.run.recommenu

import android.app.Application
import io.realm.Realm

class RMenuApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
    }
}