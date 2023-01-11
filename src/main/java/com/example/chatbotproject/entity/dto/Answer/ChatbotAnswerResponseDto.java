package com.example.chatbotproject.entity.dto.Answer;

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
    private String direction;

    @Builder
    public ChatbotAnswerResponseDto(int status, String responseMessage, String answer, String direction) {
        this.status = status;
        this.responseMessage = responseMessage;
        this.answer = answer;
        this.direction = direction;
    }
}
