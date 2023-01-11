package com.example.chatbotproject.dto;

import com.example.chatbotproject.config.BaseResponseStatus;
import com.example.chatbotproject.constants.ExceptionCode;
import com.example.chatbotproject.constants.SuccessCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static com.example.chatbotproject.config.BaseResponseStatus.SUCCESS;

@Getter
@NoArgsConstructor
public class BaseResponse {

    private Boolean succcess;
    private String msg;
    private LocalDateTime timestamp = LocalDateTime.now();

    public BaseResponse(Boolean success, String msg) {
        this.succcess = success;
        this.msg = msg;
    }

    public static BaseResponse of(Boolean success, String msg){
        return new BaseResponse(success, msg);
    }

    public static ResponseEntity<BaseResponse> toCustomErrorResponse(
            ExceptionCode exceptionCode) {
        return ResponseEntity
                .status(exceptionCode.getStatus())
                .body(BaseResponse.of(false, exceptionCode.getMsg()));
    }

    public static ResponseEntity<BaseResponse> toBasicErrorResponse(HttpStatus status, String msg) {
        return ResponseEntity
                .status(status)
                .body(BaseResponse.of(false, msg));
    }

    public static ResponseEntity<BaseResponse> toSuccessResponse(SuccessCode successCode) {
        return ResponseEntity
                .status(successCode.getStatus())
                .body(BaseResponse.of(true, successCode.getMsg()));
    }
}
