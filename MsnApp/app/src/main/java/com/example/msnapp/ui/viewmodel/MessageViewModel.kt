package com.example.msnapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.msnapp.model.Message
import com.example.msnapp.repository.MessageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MessageViewModel(private val repository: MessageRepository): ViewModel() {
    private val _messages = MutableStateFlow<List<Message>>(emptyList())

    val message: StateFlow<List<Message>> = _messages.asStateFlow()

    //observa o fluxo de mensagens do repository
    init {
        viewModelScope.launch {
            repository.allMessages.collect {
                _messages.value = it
            }
        }
    }

    fun addMessage(content: String){
        viewModelScope.launch {
            val newMessage = Message(
                content = content,
                timesTamp = System.currentTimeMillis())
            _messages.value = _messages.value + newMessage
            repository.addMessage(content)  //para salvar no banco
        }
    }


}