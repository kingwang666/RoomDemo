package com.wang.roomdemo.mode

/**
 * Author: wangxiaojie6
 * Date: 2018/4/11
 */
class UserPhone {

    @JvmField
    var firstName: String = ""

    @JvmField
    var lastName: String = ""

    @JvmField
    var phone: String = ""

    override fun toString(): String {
        return "UserPhone(firstName='$firstName', lastName='$lastName', phone=$phone)"
    }


}