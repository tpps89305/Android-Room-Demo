package com.dispy.roomdemo

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow


/**
 * Created by tpps8 on 2021/11/20
 *
 */
class AppRepository(private val dao: UserDao) {

    val allUsers: Flow<List<User>> = dao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(user: User) {
        dao.insertAll(user)
    }
}