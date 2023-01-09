package com.example.chatbotproject.service;

import com.example.chatbotproject.JFastTexts;
import com.example.chatbotproject.TokenizeDataSet;
import com.example.chatbotproject.entity.Chatbot;
import com.example.chatbotproject.entity.Question;
import com.example.chatbotproject.repository.ChatbotRepository;
import com.example.chatbotproject.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChatbotAnalyzeService {

    public final ChatbotRepository chatbotRepository;
    public final QuestionRepository questionRepository;
    public final TokenizeDataSet tokenizeDataSet;
    public final JFastTexts jFastTexts;
    public String intentLabel;

    @Transactional
    public String getAnalyzeIntent() {
        System.out.println("start analyzing intent");
        String path = "C:/Users/PERSONA SYSTEM/Desktop/HEESOO/chatbotproject/src/main/resources/data/labeled_data.txt";
        ArrayList<String> sentences, tokenizedSentences;
        List<Question> questionsList = new ArrayList<>();

        sentences = tokenizeDataSet.readTxtFile(path);
        System.out.println(sentences.get(0));
        tokenizedSentences = tokenizeDataSet.tokenize(sentences);

        jFastTexts.jfasttextPizza(tokenizedSentences.get(0));
        System.out.println("finish analyzing intent");

        intentLabel = jFastTexts.intent_label;

        System.out.println("give analyze answer");
        //List<Question> intentList = questionRepository.findByIntent(intentLabel);
        String intentList = chatbotRepository.findByIntent("__label__주문").getAnswer();
        return intentList;

    }
}
