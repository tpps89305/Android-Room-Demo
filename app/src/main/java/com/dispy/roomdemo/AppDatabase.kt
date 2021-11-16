package com.dispy.roomdemo

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by tpps8 on 2021/11/15
 *
 */

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}