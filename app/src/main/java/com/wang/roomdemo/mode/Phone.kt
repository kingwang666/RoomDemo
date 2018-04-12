package com.wang.roomdemo.mode

import android.arch.persistence.room.*

/**
 * Author: wangxiaojie6
 * Date: 2018/4/8
 */
@Entity(
        foreignKeys = [
            ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["user_id"], onDelete = ForeignKey.SET_DEFAULT)
        ]/*,
        indices = [
            Index("user_id")
        ]*/)
class Phone {

    @PrimaryKey
    @JvmField
    @ColumnInfo(name = "id")
    var id: Int = 0

    @JvmField
    var phone: String = ""

    @ColumnInfo(name = "user_id")
    @JvmField
    var userId: Int? = null

    override fun toString(): String {
        return "Phone(phoneId=$id, phone='$phone', userId=$userId)"
    }


}