package com.wang.roomdemo.room.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import com.wang.roomdemo.mode.User
import com.wang.roomdemo.room.dao.UserDao
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.wang.roomdemo.mode.Phone
import com.wang.roomdemo.room.dao.PhoneDao


/**
 * Author: wangxiaojie6
 * Date: 2018/4/4
 */
@Database(entities = [User::class, Phone::class], version = 3)
abstract class AppDatabase : RoomDatabase() {

//    companion object {
//
//        @Volatile
//        private var sInstance: AppDatabase? = null
//
//        @JvmStatic
//        fun getInstance(context: Context): AppDatabase{
//            var database = sInstance
//            return database ?: let {
//                synchronized(AppDatabase::class.java){
//                    database = sInstance
//                   database ?: let{
//                        Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app-database").build().also {
//                            sInstance = it
//                        }
//                    }
//                }
//            }
//        }
//    }

    abstract fun userDao(): UserDao

    abstract fun phoneDao(): PhoneDao
}