package com.example.msnapp.ui.theme.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.example.msnapp.ui.viewmodel.MessageViewModel
import androidx.compose.runtime.*


@Composable
fun MessageApp(viewModel: MessageViewModel) {
    var messageText by remember { mutableStateOf(TextFieldValue("")) }

    val messages by viewModel.message.collectAsState(initial = emptyList())

    val listState = rememberLazyListState()

    LaunchedEffect(messages.size) {
        listState.animateScrollToItem(messages.size)
    }
}

@Composable
fun MessageBubble(content: String, isUserMessage: Boolean) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = if (isUserMessage) Arrangement.End
        else Arrangement.Start
    ) {
        Box(
            modifier = Modifier.background(
                color = if (isUserMessage) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.surface
            )
                .padding(12.dp)
                .widthIn(max = 250.dp)
        ) {
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = (if (isUserMessage){
                        MaterialTheme.colorScheme.onPrimary
                    }else{
                        MaterialTheme.colorScheme.onSurface
                    }) as Color
                )
            )
        }
    }
}