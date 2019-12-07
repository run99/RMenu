package com.run.recommenu

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*


//継承可能にするためにopen修飾子をつける
open class Recipe(
    @PrimaryKey open var id : String = UUID.randomUUID().toString(),
    open var imageId: Int = 0,
    @Required open var food : String = "",
    open var date: Date = Date(System.currentTimeMillis())

) : RealmObject()