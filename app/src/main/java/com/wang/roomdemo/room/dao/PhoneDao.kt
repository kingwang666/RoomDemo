package com.wang.roomdemo.room.dao

import androidx.room.*
import com.wang.roomdemo.mode.Phone
import com.wang.roomdemo.mode.PhoneFts

/**
 * Author: wangxiaojie6
 * Date: 2018/4/8
 */
@Dao
interface PhoneDao {

    @Query("SELECT * FROM Phone")
    fun getAll(): List<Phone>

    @Query("SELECT * FROM Phone WHERE phone_id IN (:ids)")
    fun getPhonesByIds(ids: IntArray): List<Phone>

    @Query("SELECT * FROM Phone WHERE phone_id = :id")
    fun getPhoneById(id: Int): Phone?

    @Query("SELECT * FROM Phone WHERE user_id = :userId")
    fun getPhoneByUserId(userId: Int?): List<Phone>

    @Query("select * from Phone where user_id is null")
    fun getPhoneByNull(): List<Phone>

    @Query("SELECT Phone.phone_id, Phone.phone, Phone.user_id FROM Phone INNER JOIN users ON Phone.user_id = users.user_id WHERE users.last_name LIKE :lastName AND users.first_name LIKE :firstName")
    fun getPhoneByUserName(firstName: String, lastName: String): List<Phone>

    @Query("SELECT * FROM phone_fts WHERE phone_fts MATCH :query")
    fun search(query: String): List<PhoneFts>

    @Query("SELECT * FROM phone INNER JOIN phone_fts ON (Phone.phone_id = phone_fts.docid) WHERE phone_fts MATCH :query")
    fun search2(query: String): List<Phone>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg phones: Phone)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(phone: Phone)

    @Update
    fun update(phone: Phone)

    @Delete
    fun delete(phone: Phone)

    @Query("DELETE FROM phone")
    fun deleteAll()
}