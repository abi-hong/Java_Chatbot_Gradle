package com.example.chatbotproject.service;

import com.example.chatbotproject.JFastTexts;
import com.example.chatbotproject.TokenizeDataSet;
import com.example.chatbotproject.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class IntentAnalyzeService {

    public final AnswerRepository answerRepository;
    public final TokenizeDataSet tokenizeDataSet;
    public final JFastTexts jFastTexts;
    public String intentLabel;

    @Transactional
    public String getAnalyzeIntent(String question) {

        // analyze intent
        System.out.println("start analyzing intent");
        System.out.println("typed : " + question);

        String tokenizedSentences = tokenizeDataSet.tokenizeQuestion(question);
        String intent = jFastTexts.getIntent(tokenizedSentences);

        return answerRepository.findByIntent(intent).getAnswer();

    }
}
