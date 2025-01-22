package com.example.msnapp.data.local.dao.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.example.msnapp.model.Message


@Dao
interface MessageDao {
    @Query("SELECT * FROM messages ORDER BY timesTamp DESC")
            fun getAllMessages(): Flow<List<Message>>

            @Insert
            suspend fun insertMessage(message: Message)
}