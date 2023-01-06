package com.example.chatbotproject.controller;

import com.example.chatbotproject.entity.Chatbot;
import com.example.chatbotproject.repository.ChatbotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatbotController {

    private final ChatbotRepository chatbotRepository;

    @GetMapping("/chatbot")
    public List<Chatbot> findAllChatbot() {
        return chatbotRepository.findAll();
    }
}
