package com.wang.roomdemo.mode

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Author: wangxiaojie6
 * Date: 2018/4/4
 */
@Entity(tableName = "users")
class User {

    @PrimaryKey
    @JvmField
//    @ColumnInfo(name = "user_id")
    var id: Int = 0

    @ColumnInfo(name = "first_name")
    @JvmField
    var firstName: String = ""

    @ColumnInfo(name = "last_name")
    @JvmField
    var lastName: String = ""

    @JvmField
    var age: Int = 0

    @JvmField
    @Embedded(prefix = "account_")
    var accountAddr: Address? = null

    @JvmField
    @Embedded(prefix = "live_")
    var liveAddr: Address? = null

    override fun toString(): String {
        return "User(id=$id, firstName='$firstName', lastName='$lastName', age=$age, accountAddr=$accountAddr, liveAddr=$liveAddr)"
    }


}