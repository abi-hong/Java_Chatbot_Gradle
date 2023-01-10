package com.example.chatbotproject.entity.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatbotAnswerResponseDto {

    private int status;
    private String responseMessage;
    private String answer;

    @Builder
    public ChatbotAnswerResponseDto(int status, String responseMessage, String answer) {
        this.status = status;
        this.responseMessage = responseMessage;
        this.answer = answer;
    }
}
