package com.example.chatbotproject.entity.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatbotOrderAnswerResponseDB {

    private int status;
    private String responseMessage;
    private String answer;
    private String direction;

    @Builder
    private ChatbotOrderAnswerResponseDB(int status, String responseMessage, String answer, String direction) {
        this.status = status;
        this.responseMessage = responseMessage;
        this.answer = answer;
        this.direction = direction;
    }

}
