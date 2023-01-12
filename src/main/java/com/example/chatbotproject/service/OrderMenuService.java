package com.example.chatbotproject.service;

import com.example.chatbotproject.controller.ChatbotController;
import com.example.chatbotproject.dto.req.order.ChatbotOrderMenuListRequestDto;
import com.example.chatbotproject.dto.req.order.OrderMenuRequestDto;
import com.example.chatbotproject.dto.res.order.ChatbotOrderMenuListResponseDto;
import com.example.chatbotproject.dto.res.order.OrderMenuResponseDto;
import com.example.chatbotproject.repository.MenuRepository;
import com.example.chatbotproject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderMenuService {

    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;

    public ChatbotOrderMenuListResponseDto  menuList(ChatbotOrderMenuListRequestDto request) {
        if (request.getUserTypedMessage() == 1) { // Yes
            return ChatbotOrderMenuListResponseDto.of(menuRepository.findAll());
        } else if (request.getUserTypedMessage() == 2) { // No
            return ChatbotOrderMenuListResponseDto.of(null);
        } else {
            return ChatbotOrderMenuListResponseDto.of(null);
        }
    }

    public OrderMenuResponseDto orderMenu(OrderMenuRequestDto request) {
        if(request.getOrderMenu() == null) {
            return OrderMenuResponseDto.of("메뉴 이름을 다시 입력해주세요.");
        } else {
            return OrderMenuResponseDto.of("주문하실 수량을 입력해주세요");
        }
    }


}
