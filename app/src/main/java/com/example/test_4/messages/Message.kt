package com.example.test_4.messages

data class Message(
    val id: Int,
    val image: String,
    val owner: String,
    var lastMessage: String,
    var lastActive: String,
    var unreadMessages: Int,
    var isTyping: Boolean,
    var lastMessageType: MessageType
) {
    enum class MessageType {
        TEXT,
        FILE,
        VOICE
    }
}
