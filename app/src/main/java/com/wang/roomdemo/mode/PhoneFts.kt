package com.wang.roomdemo.mode

import androidx.room.Entity
import androidx.room.Fts4

/**
 * Created on 2022/9/14
 * Author: wangxiaojie
 * Description:
 */
@Entity(tableName = "phone_fts")
@Fts4(contentEntity = Phone::class)
class PhoneFts constructor(
    @JvmField
    val phone: String
) {

    override fun toString(): String {
        return "PhoneFts(phone='$phone')"
    }
}