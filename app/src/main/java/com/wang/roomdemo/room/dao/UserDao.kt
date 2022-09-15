package com.wang.roomdemo.room.dao

import androidx.room.*
import com.wang.roomdemo.mode.NameTuple
import com.wang.roomdemo.mode.User
import com.wang.roomdemo.mode.UserPhone


/**
 * Author: wangxiaojie6
 * Date: 2018/4/4
 * 注意当使用 android.arch.persistence.room:rxjava2。如果不调用dispose，就会一直观察数据库 发生变动就会通知
 * 而我这demo不需要这样所以不用 android.arch.persistence.room:rxjava2。
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE user_id IN (:ids)")
    fun getUsersByIds(ids: IntArray): List<User>

    @Query("SELECT * FROM users WHERE user_id LIKE :id")
    fun getUserById(id: Int): User?

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    fun getUserByName(first: String, last: String): User?

    @Query("SELECT * FROM users WHERE age > :age")
    fun getUsersOlderThan(age: Int): List<User>

    @Query("SELECT * FROM users WHERE age BETWEEN :min AND :max")
    fun getUserBetweenAge(min: Int, max: Int): List<User>

    @Query("SELECT first_name, last_name FROM users")
    fun getName(): List<NameTuple>

    @Query("SELECT users.first_name AS firstName, users.last_name AS lastName, Phone.phone From users, Phone WHERE users.user_id = Phone.user_id")
    fun getNameAndPhone(): List<UserPhone>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("DELETE FROM users")
    fun deleteAll()

}