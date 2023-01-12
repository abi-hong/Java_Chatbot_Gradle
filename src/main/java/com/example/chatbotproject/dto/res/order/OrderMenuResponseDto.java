package com.example.chatbotproject.dto.res.order;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderMenuResponseDto {

    private String direction;

    private OrderMenuResponseDto(String direction) {
        this.direction = direction;
    }

    public static OrderMenuResponseDto of(String direction) {
        return new OrderMenuResponseDto(direction);
    }
}
