package com.wang.roomdemo

import android.content.Context
import android.util.Log
import com.wang.roomdemo.mode.*
import io.reactivex.disposables.Disposable

/**
 * Author: wangxiaojie6
 * Date: 2018/4/4
 */
class MainActivityPresenter {

    private val mRepository: LocalRepository
    private val mView: IView

    constructor(context: Context, view: IView) {
        mRepository = LocalRepository.getInstance(context)
        mView = view
    }

    fun add(id: Int = 0, firstName: String = "wang", lastName: String = "xiaojie", age: Int = 18): Disposable {
        val user = User().apply {
            this.id = id
            this.firstName = firstName
            this.lastName = lastName
            this.age = age
            accountAddr = Address().apply {
                province = "zhejiang"
                city = "tongxiang"
            }
        }
        return mRepository.insert(user, object : WSubscriber<Boolean>() {
            override fun success(t: Boolean) {
                mView.addSuccess(user)
            }

            override fun error(error: String?) {
                Log.e("test", error)
            }

        })
    }

    fun deleteUser(id: Int = 0): Disposable {
        val user = User().apply {
            this.id = id
        }
        return mRepository.delete(user, object : WSubscriber<Boolean>() {
            override fun success(t: Boolean) {
                mView.deleteSuccess(user)
            }

            override fun error(error: String?) {
                Log.e("test", error)
            }

        })
    }

    fun getAll(): Disposable {
        return mRepository.getAll(object : WSubscriber<List<User>>() {

            override fun success(t: List<User>) {
                mView.getAllSuccess(t)
            }

            override fun error(error: String?) {

            }
        })
    }

    fun addPhone(id: Int = 0, userId: Int? = null, phoneNumber: String = "15757126090"): Disposable {
        val phone = Phone().apply {
            this.id = id
            this.phone = phoneNumber
            this.userId = userId
        }
        return mRepository.insert(phone, object : WSubscriber<Boolean>() {
            override fun success(t: Boolean) {

            }

            override fun error(error: String?) {
                Log.e("test", error)
            }

        })
    }

    fun getAllPhone(): Disposable {
        return mRepository.getAllPhone(object : WSubscriber<List<Phone>>() {

            override fun success(t: List<Phone>) {
                Log.d("test", t.toString())
            }

            override fun error(error: String?) {

            }
        })
    }

    fun getName(): Disposable {
        return mRepository.getName(object : WSubscriber<List<NameTuple>>() {
            override fun success(t: List<NameTuple>) {
                Log.d("test", t.toString())
            }

            override fun error(error: String?) {
                Log.e("test", error ?: "")
            }
        })
    }

    fun deleteAllUser(): Disposable {
        return mRepository.deleteAllUser(object : WSubscriber<Boolean>() {

            override fun success(t: Boolean) {

            }

            override fun error(error: String?) {
                Log.e("test", error ?: "")
            }
        })
    }

    fun deleteAllPhone(): Disposable {
        return mRepository.deleteAllPhone(object : WSubscriber<Boolean>() {

            override fun success(t: Boolean) {

            }

            override fun error(error: String?) {
                Log.e("test", error ?: "")
            }
        })
    }

    fun getNoOwnerPhone(): Disposable {
        return mRepository.getNoOwnerPhone(object : WSubscriber<List<Phone>>() {

            override fun success(t: List<Phone>) {
                Log.d("test", t.toString())
            }

            override fun error(error: String?) {
                Log.e("test", error ?: "")
            }
        })
    }

    fun getPhoneByName(firstName: String, lastName: String): Disposable {
        return mRepository.getPhoneByName(firstName, lastName, object : WSubscriber<List<Phone>>() {

            override fun success(t: List<Phone>) {
                Log.d("test", t.toString())
            }

            override fun error(error: String?) {
                Log.e("test", error ?: "")
            }
        })
    }

    fun getNameAndPhone(): Disposable {
        return mRepository.getNameAndPhone(object : WSubscriber<List<UserPhone>>() {

            override fun success(t: List<UserPhone>) {
                Log.d("test", t.toString())
            }

            override fun error(error: String?) {
                Log.e("test", error ?: "")
            }
        })
    }

    interface IView {

        fun addSuccess(user: User)
        fun getAllSuccess(t: List<User>)
        fun deleteSuccess(user: User)

    }
}