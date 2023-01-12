package com.example.chatbotproject.controller;

import com.example.chatbotproject.dto.BaseResponse;
import com.example.chatbotproject.dto.req.answer.ChatbotAnswerRequestDto;
import com.example.chatbotproject.dto.req.order.ChatbotOrderMenuListRequestDto;
import com.example.chatbotproject.dto.res.answer.ChatbotAnswerResponseDto;
import com.example.chatbotproject.dto.res.order.ChatbotOrderMenuListResponse;
import com.example.chatbotproject.dto.res.order.ChatbotOrderMenuListResponseDto;
import com.example.chatbotproject.repository.MenuRepository;
import com.example.chatbotproject.service.IntentAnalyzeService;
import com.example.chatbotproject.service.ChatbotDbService;
import com.example.chatbotproject.service.OrderMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.example.chatbotproject.constants.SuccessCode.LOAD_MENU_LIST_SUCCESS;

@RequiredArgsConstructor
@RestController
public class ChatbotController {

    private final ChatbotDbService chatbotDbService;
    private final IntentAnalyzeService intentAnalyzeService;
    private final OrderMenuService userChatbotService;
    private final MenuRepository menuRepository;
    private final OrderMenuService orderMenuService;

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
    /*@PostMapping("/post/answers")
    public ChatbotAnswerResponseDto getQuestions(@RequestBody ChatbotAnswerRequestDto requestDto) {
        System.out.println("getQuestions controller start");
        String answer = intentAnalyzeService.getAnalyzeIntent(requestDto.getTypedMessage());
        ChatbotAnswerResponseDto dto = ChatbotAnswerResponseDto.builder()
                .status(SuccessCode.OK)
                .responseMessage(ANSWER_SUCCESS)
                .answer(answer)
                .direction("Yes는 1, No는 2를 입력해주세요. Exit은 0을 입력해주세요.")
                .build();

        return dto;
    }
     */

    // 첫 주문 지시 후, 사용자한테 Yes, No, Exit에 해당하는 숫자 받고 각 숫자에 해당하는 다음 지시문 리턴
    @GetMapping("/api/chatbot/answer/4")
    public ResponseEntity<ChatbotOrderMenuListResponse> getMenu(@RequestParam(value = "yesno") int yesno) {

        // 받아온 데이터가 많은 경우 dto로 묶어서 전달하기 위해
        ChatbotOrderMenuListRequestDto requestDto = ChatbotOrderMenuListRequestDto.of(yesno);

        ChatbotOrderMenuListResponseDto responseDto = orderMenuService.menuList(requestDto);
        return ChatbotOrderMenuListResponse.newResponse(LOAD_MENU_LIST_SUCCESS, responseDto);
    }

    @PostMapping("/api/chatbot/")

}
