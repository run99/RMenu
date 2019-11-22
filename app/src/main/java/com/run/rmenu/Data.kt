package com.run.rmenu

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*


//継承可能にするためにopen修飾子をつける
open class Data(
    @PrimaryKey open var id : String = UUID.randomUUID().toString(),
    @Required open var food : String = "",

    open var price : Long = 0
) : RealmObject()