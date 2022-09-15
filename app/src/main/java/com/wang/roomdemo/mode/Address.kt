package com.wang.roomdemo.mode

import androidx.room.ColumnInfo


/**
 * Author: wangxiaojie6
 * Date: 2018/4/8
 */
class Address {

    @JvmField
    var province: String = ""

    @JvmField
    var city: String = ""

    @ColumnInfo(name = "post_code")
    @JvmField
    var postCode: Int = 0

    override fun toString(): String {
        return "Address(province='$province', city='$city', postCode=$postCode)"
    }


}