package com.example.chatbotproject.dto.res.order;

import com.example.chatbotproject.constants.SuccessCode;
import com.example.chatbotproject.dto.BaseResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Getter
@NoArgsConstructor
public class OrderMenuResponse extends BaseResponse {

    private OrderMenuResponseDto data;

    private OrderMenuResponse(Boolean success, String msg, OrderMenuResponseDto data) {
        super(success, msg);
        this.data = data;
    }

    public static ResponseEntity<OrderMenuResponse> newResponse(SuccessCode code, OrderMenuResponseDto data) {
        OrderMenuResponse response = new OrderMenuResponse(true, code.getMsg(), data);
        return new ResponseEntity(response, code.getStatus());
    }
}
