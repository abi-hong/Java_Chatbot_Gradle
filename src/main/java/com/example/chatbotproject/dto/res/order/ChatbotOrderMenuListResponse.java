package com.example.chatbotproject.dto.res.order;

import com.example.chatbotproject.dto.BaseResponse;
import com.example.chatbotproject.constants.ExceptionCode;
import com.example.chatbotproject.constants.SuccessCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Getter
@NoArgsConstructor
public class ChatbotOrderMenuListResponse extends BaseResponse { //todo super() 사용, ResponseEntity 객체 사용

    private ChatbotOrderMenuListResponseDto data;

    private ChatbotOrderMenuListResponse(Boolean success, String msg, ChatbotOrderMenuListResponseDto data) {
        super(success, msg);
        this.data = data;
    }

    public static ResponseEntity<ChatbotOrderMenuListResponse> newResponse(SuccessCode code, ChatbotOrderMenuListResponseDto data) {
        ChatbotOrderMenuListResponse response = new ChatbotOrderMenuListResponse(true, code.getMsg(), data);
        return new ResponseEntity(response, code.getStatus());
    }
}
