package com.wang.roomdemo.mode

import androidx.room.*

/**
 * Author: wangxiaojie6
 * Date: 2018/4/8
 */
@Entity(
        foreignKeys = [
            ForeignKey(entity = User::class, parentColumns = ["user_id"], childColumns = ["user_id"], onDelete = ForeignKey.CASCADE)
        ],
        indices = [
            Index("user_id")
        ])
class Phone {

    @PrimaryKey
    @JvmField
    @ColumnInfo(name = "phone_id")
    var phoneId: Int = 0

    @JvmField
    var phone: String = ""

    @ColumnInfo(name = "user_id")
    @JvmField
    var userId: Int? = null

    override fun toString(): String {
        return "Phone(phoneId=$phoneId, phone='$phone', userId=$userId)"
    }


}