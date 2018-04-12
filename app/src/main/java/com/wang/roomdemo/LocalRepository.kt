package com.wang.roomdemo

import android.arch.persistence.room.Room
import android.content.Context
import com.wang.roomdemo.mode.NameTuple
import com.wang.roomdemo.mode.Phone
import com.wang.roomdemo.mode.User
import com.wang.roomdemo.mode.UserPhone
import com.wang.roomdemo.room.database.AppDatabase
import com.wang.roomdemo.room.database.RoomRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Author: wangxiaojie6
 * Date: 2018/4/4
 */
class LocalRepository private constructor(context: Context) : RoomRepository() {

    companion object {

        @Volatile
        private var sInstance: LocalRepository? = null

        @JvmStatic
        fun getInstance(context: Context): LocalRepository {
            var repository = sInstance
            return repository ?: let {
                synchronized(LocalRepository::class.java) {
                    repository = sInstance
                    repository ?: let {
                        LocalRepository(context.applicationContext).also {
                            sInstance = it
                        }
                    }
                }
            }
        }
    }

    private val mDatabase: AppDatabase = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app-database").addMigrations(MIGRATION_1_2, MIGRATION_2_3).build()

    fun getAll(subscriber: WSubscriber<List<User>>): Disposable {
        return Flowable.just("")
                .map {
                    mDatabase.userDao().getAll()
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)
    }

    fun getName(subscriber: WSubscriber<List<NameTuple>>): Disposable{
        return Flowable.just("")
                .map {
                    mDatabase.userDao().getName()
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)
    }

    fun getUsersByIds(ids: IntArray, subscriber: WSubscriber<List<User>>): Disposable {
        return Flowable.just("")
                .map {
                    mDatabase.userDao().getUsersByIds(ids)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)
    }

    fun getUserById(id: Int, subscriber: WSubscriber<User>): Disposable {
        return Flowable.just("")
                .map {
                    mDatabase.userDao().getUserById(id)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)

    }

    fun getUserByName(first: String, last: String, subscriber: WSubscriber<User>): Disposable {
        return Flowable.just("")
                .map {
                    mDatabase.userDao().getUserByName(first, last)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)
    }

    fun insert(user: User, subscriber: WSubscriber<Boolean>): Disposable {
        return Flowable.just(user)
                .map {
                    mDatabase.userDao().insert(it)
                    true
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)
    }

    fun delete(user: User, subscriber: WSubscriber<Boolean>): Disposable {
        return Flowable.just(user)
                .map {
                    mDatabase.userDao().delete(it)
                    true
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)
    }

    fun getAllPhone(subscriber: WSubscriber<List<Phone>>): Disposable {
        return Flowable.just("")
                .map {
                    mDatabase.phoneDao().getAll()
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)
    }

    fun insert(phone: Phone, subscriber: WSubscriber<Boolean>): Disposable {
        return Flowable.just(phone)
                .map {
                    mDatabase.phoneDao().insert(it)
                    true
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)
    }

    fun deleteAllUser(subscriber: WSubscriber<Boolean>): Disposable{
        return Flowable.just("")
                .map {
                    mDatabase.userDao().deleteAll()
                    true
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)
    }

    fun deleteAllPhone(subscriber: WSubscriber<Boolean>): Disposable{
        return Flowable.just("")
                .map {
                    mDatabase.phoneDao().deleteAll()
                    true
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)
    }

    fun getNoOwnerPhone(subscriber: WSubscriber<List<Phone>>): Disposable{
        return Flowable.just("")
                .map {
                    mDatabase.phoneDao().getPhoneByNull()
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)
    }

    fun getPhoneByName(firstName: String, lastName: String, subscriber: WSubscriber<List<Phone>>): Disposable{
        return Flowable.just("")
                .map {
                    mDatabase.phoneDao().getPhoneByUserName(firstName, lastName)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)
    }

    fun getNameAndPhone(subscriber: WSubscriber<List<UserPhone>>):Disposable{
        return Flowable.just("")
                .map {
                    mDatabase.userDao().getNameAndPhone()
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber)
    }
}