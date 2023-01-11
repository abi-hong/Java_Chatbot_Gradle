package com.example.chatbotproject.entity.dto.orderAnswers;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatbotOrderAnswerRequestDto {
    private String intent;
    private int userTypedMessage;

}
