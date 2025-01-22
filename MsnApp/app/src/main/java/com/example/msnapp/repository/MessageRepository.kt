package com.example.msnapp.repository

import com.example.msnapp.data.local.dao.dao.MessageDao
import com.example.msnapp.model.Message
import kotlinx.coroutines.flow.Flow

class MessageRepository(private val dao: MessageDao) {
    val allMessages: Flow<List<Message>> = dao.getAllMessages()

    suspend fun addMessage(content: String){
        val message = Message(
            content = content,
            timesTamp = System.currentTimeMillis()
        )

        dao.insertMessage(message)
    }
}