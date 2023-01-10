package com.example.chatbotproject.controller;

import com.example.chatbotproject.entity.dto.ChatbotAnswerRequestDto;
import com.example.chatbotproject.entity.dto.ChatbotAnswerResponseDto;
import com.example.chatbotproject.entity.dto.ResponseMessage;
import com.example.chatbotproject.entity.dto.StatusCode;
import com.example.chatbotproject.service.IntentAnalyzeService;
import com.example.chatbotproject.service.ChatbotDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RequiredArgsConstructor
@RestController
public class ChatbotController {

    private final ChatbotDbService chatbotDbService;
    private final IntentAnalyzeService intentAnalyzeService;

    // 사용자가 던진 질문 DB에 저장
    @GetMapping("/save/questions")
    public String insertQuestions(){
        System.out.println("insertQuestions controller start");
        chatbotDbService.saveAllQuestions();
        return " ";
    }

    // 각 의도에 관한 답변 DB에 저장
    @GetMapping("/save/answers")
    public String insertAnswers() throws IOException {
        System.out.println("insertAnswers controller start");
        chatbotDbService.saveAllAnswers();
        return " ";
    }

    // 사용자 짏문을 분석 후, intent와 맞는 답변 출력
    @PostMapping("/post/answers")
    public ChatbotAnswerResponseDto getQuestions(@RequestBody ChatbotAnswerRequestDto requestDto) {
        System.out.println("getQuestions controller start");
        String answer = intentAnalyzeService.getAnalyzeIntent(requestDto.getTypedMessage());
        ChatbotAnswerResponseDto dto = ChatbotAnswerResponseDto.builder()
                .status(StatusCode.OK)
                .responseMessage(ResponseMessage.ANSWER_SUCCESS)
                .answer(answer)
                .build();

        return dto;
    }
}
