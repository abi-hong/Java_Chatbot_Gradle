package com.example.chatbotproject.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.OK;

@Getter
@AllArgsConstructor
public enum SuccessCode { //todo enum 찾아보기, HttpStatus 찾아보기

    LOAD_MENU_LIST_SUCCESS(OK, "메뉴 리스트 조회에 성공하였습니다.");

    private final HttpStatus status;
    private final String msg;
}
