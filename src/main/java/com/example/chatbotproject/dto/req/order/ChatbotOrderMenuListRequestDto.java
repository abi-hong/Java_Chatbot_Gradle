package com.example.chatbotproject.dto.req.order;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatbotOrderMenuListRequestDto {
    //private String intent;
    private int userTypedMessage;

    private ChatbotOrderMenuListRequestDto(int userTypedMessage) {
        this.userTypedMessage = userTypedMessage;
    }

    public static ChatbotOrderMenuListRequestDto of(int userTypedMessage) {
        return new ChatbotOrderMenuListRequestDto(userTypedMessage);
    }
}
