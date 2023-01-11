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

        List<ChatbotOrderMenuListResponseDto.MenuList> menus;

        if(request.getUserTypedMessage() == 1) {

        }
    }
}
