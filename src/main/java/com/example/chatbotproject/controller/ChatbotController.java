package com.example.chatbotproject.controller;

import com.example.chatbotproject.service.ChatbotDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RequiredArgsConstructor
@RestController
public class ChatbotController {

    private final ChatbotDbService chatbotDbService;

    @GetMapping("/save/questions")
    public String insertQuestions(){
        System.out.println("controller start");
        chatbotDbService.saveAllQuestions();
        return " ";
    }

    @GetMapping("/save/answers")
    public String insertAnswers() throws IOException {
        System.out.println("controller start");
        chatbotDbService.saveAllAnswers();
        return " ";
    }


}
