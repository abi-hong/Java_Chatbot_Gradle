package com.example.chatbotproject.service;

import com.example.chatbotproject.controller.ChatbotController;
import com.example.chatbotproject.dto.req.order.ChatbotOrderMenuListRequestDto;
import com.example.chatbotproject.dto.res.order.ChatbotOrderMenuListResponseDto;
import com.example.chatbotproject.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderMenuService {

    private final MenuRepository menuRepository;

    public ChatbotOrderMenuListResponseDto  menuList(ChatbotOrderMenuListRequestDto request) {
        if (request.getUserTypedMessage() == 1) { // Yes
            return ChatbotOrderMenuListResponseDto.of(menuRepository.findAll());
        } else if (request.getUserTypedMessage() == 2) { // No
            return ChatbotOrderMenuListResponseDto.of(null);
        } else {
            return ChatbotOrderMenuListResponseDto.of(null);
        }
    }
}
