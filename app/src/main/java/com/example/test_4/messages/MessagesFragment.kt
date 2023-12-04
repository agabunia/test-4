package com.example.test_4.messages

import com.example.test_4.BaseFragment
import com.example.test_4.databinding.FragmentMessagesBinding

class MessagesFragment : BaseFragment<FragmentMessagesBinding>(FragmentMessagesBinding::inflate) {
    override fun setUp() {
        binding.btnSearch.setOnClickListener {  }
    }

    override fun setListeners() {
        binding.btnSearch.setOnClickListener {  }
    }

    override fun observeData() {
        binding.btnSearch.setOnClickListener {  }
    }
}