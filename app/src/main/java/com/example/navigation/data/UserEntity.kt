package com.example.navigation.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity ("user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String?,
    val age: Int?
)
