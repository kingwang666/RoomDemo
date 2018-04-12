package com.wang.roomdemo.mode

import android.arch.persistence.room.ColumnInfo

/**
 * Author: wangxiaojie6
 * Date: 2018/4/10
 */
class NameTuple {

    @ColumnInfo(name = "first_name")
    @JvmField
    var firstName: String = ""

    @ColumnInfo(name = "last_name")
    @JvmField
    var lastName: String = ""

    override fun toString(): String {
        return "NameTuple(firstName='$firstName', lastName='$lastName')"
    }


}