package com.example.chatbotproject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChatbotAnswerDb {
    String oneLine = null;
    List<String> intents = new ArrayList<>();
    List<String> answers = new ArrayList<>();

    public void splitAnswers() throws IOException {
        System.out.println("splitAnswers start");
        String path = "C:/Users/PERSONA SYSTEM/Desktop/HEESOO/chatbotproject/src/main/resources/data/intent_answer_data.txt";
        BufferedReader bfr = new BufferedReader(new FileReader(new File(path)));

        while((oneLine = bfr.readLine()) != null) {
            String[] datas = oneLine.split(",");
            intents.add(datas[0]);
            answers.add(datas[1]);
        }
    }

    public List<String> returnIntents() {
        return intents;
    }

    public List<String> returnAnswers() {
        return answers;
    }
}

