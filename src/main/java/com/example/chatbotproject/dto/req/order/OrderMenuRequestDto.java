package com.example.chatbotproject.dto.req.order;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderMenuRequestDto {
    private String orderMenu;

    private OrderMenuRequestDto(String orderMenu) {
        this.orderMenu = orderMenu;
    }

    public static OrderMenuRequestDto of(String orderMenu) {
        return new OrderMenuRequestDto(orderMenu);
    }
}
