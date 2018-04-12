package com.wang.roomdemo.room.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration
import android.support.annotation.VisibleForTesting

/**
 * Author: wangxiaojie6
 * Date: 2018/4/10
 */
abstract class RoomRepository {

    companion object {

        internal val MIGRATION_1_2: Migration = object : Migration(1, 2) {

            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }

        internal val MIGRATION_2_3: Migration = object : Migration(2, 3){

            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE users_new (" +
                        "user_id INTEGER NOT NULL, " +
                        "first_name TEXT NOT NULL, " +
                        "last_name TEXT NOT NULL, " +
                        "age INTEGER NOT NULL, " +
                        "account_province TEXT, " +
                        "account_city TEXT, " +
                        "account_post_code INTEGER, " +
                        "live_province TEXT, " +
                        "live_city TEXT, " +
                        "live_post_code INTEGER, " +
                        "PRIMARY KEY(user_id))")
                database.execSQL("INSERT INTO users_new (user_id, first_name, last_name, age, account_province, account_city, account_post_code, live_province, live_city, live_post_code) " +
                        "SELECT id, first_name, last_name, age, account_province, account_city, account_post_code, live_province, live_city, live_post_code FROM users")
                database.execSQL("DROP TABLE users")
                database.execSQL("ALTER TABLE users_new RENAME TO users")

                database.execSQL("CREATE TABLE Phone_new (phone_id INTEGER NOT NULL, phone TEXT NOT NULL, user_id INTEGER, PRIMARY KEY(phone_id), FOREIGN KEY(user_id) REFERENCES users(user_id) ON DELETE SET DEFAULT)")
                database.execSQL("INSERT INTO Phone_new (phone_id, phone, user_id) SELECT id, phone, user_id FROM Phone")
                database.execSQL("DROP TABLE Phone")
                database.execSQL("ALTER TABLE Phone_new RENAME TO Phone")
            }

        }
    }


}