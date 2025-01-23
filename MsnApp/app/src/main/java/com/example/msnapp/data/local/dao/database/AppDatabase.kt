package com.example.msnapp.data.local.dao.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.msnapp.data.local.dao.dao.MessageDao
import com.example.msnapp.model.Message

@Database(entities = [Message::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun messageDao(): MessageDao
}