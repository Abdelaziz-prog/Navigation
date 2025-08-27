package com.example.navigation.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: UserEntity)

    @Query("SELECT * FROM user_table WHERE id =:id")
    suspend fun getUserById(id: Int): UserEntity

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Query("SELECT * From user_table ")
    fun readAllData(): Flow<List<UserEntity>>

}