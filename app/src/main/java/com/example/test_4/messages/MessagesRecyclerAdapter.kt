package com.example.test_4.messages


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test_4.databinding.MessageItemLayoutBinding

class MessagesRecyclerAdapter :
    ListAdapter<Message, MessagesRecyclerAdapter.MessageViewHolder>(MessageDiffUtil()) {

    class MessageDiffUtil : DiffUtil.ItemCallback<Message>() {
        override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MessageViewHolder(MessageItemLayoutBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = getItem(position)
        holder.bind(message)
    }

    inner class MessageViewHolder(private val binding: MessageItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            val context = binding.root.context
            with(binding) {
                Glide.with(context).load(message.image).into(ivUserImage)
                tvUserName.text = message.owner
                tvTime.text = message.lastActive
                tvUnreadMessageNumber.text = message.unreadMessages.toString()
                when (message.lastMessageType) {
                    Message.MessageType.TEXT -> {
                        tvMessageText.text = message.lastMessage
                    }

                    Message.MessageType.VOICE -> {
                        tvMessageText.visibility = View.GONE
                        tvMessageVoice.visibility = View.VISIBLE
                    }

                    Message.MessageType.FILE -> {
                        tvMessageText.visibility = View.GONE
                        tvMessageFile.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}