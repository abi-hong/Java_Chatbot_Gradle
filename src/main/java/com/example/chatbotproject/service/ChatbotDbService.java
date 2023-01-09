package com.example.chatbotproject.service;

import com.example.chatbotproject.JFastTexts;
import com.example.chatbotproject.ChatbotAnswerDb;
import com.example.chatbotproject.TokenizeDataSet;
import com.example.chatbotproject.entity.Chatbot;
import com.example.chatbotproject.entity.Question;
import com.example.chatbotproject.repository.ChatbotRepository;
import com.example.chatbotproject.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatbotDbService {
    public final QuestionRepository questionsRepository;
    public final TokenizeDataSet tokenizeDataSet;
    public final JFastTexts jFastTexts;
    public Question questions; //todo questions 빈 주입 문제(이건 빈 주입을 하면 안되나)
    public Chatbot chatbot;
    public final ChatbotRepository chatbotRepository;
    public final ChatbotAnswerDb chatbotAnswerDb;

    @Transactional
    public void saveAllQuestions() {
        //System.out.println("start");
        String path = "C:/Users/PERSONA SYSTEM/Desktop/HEESOO/chatbotproject/src/main/resources/data/unlabeled_data.txt";
        ArrayList<String> sentences, tokenizedSentences;
        List<Question> questionsList = new ArrayList<>();

        sentences = tokenizeDataSet.readTxtFile(path);
        System.out.println(sentences.get(0));
        tokenizedSentences = tokenizeDataSet.tokenize(sentences);

        jFastTexts.jfasttextPizza(tokenizedSentences.get(0));
        //System.out.println("jFastTexts");

        //데이터 저장
        for (String sentence: sentences) {
            questions = Question.builder()
                    .intent("")
                    .questions(sentence)
                    .build();
            questionsList.add(questions);
            //System.out.println("for문" + sentence);
        }
        //System.out.println("build");

        questionsRepository.saveAll(questionsList);
        //System.out.println("save finished");
    }

    @Transactional
    public void saveAllAnswers() throws IOException {
        System.out.println("start");
        chatbotAnswerDb.returnAnswers();
        chatbotAnswerDb.splitAnswers();
        System.out.println("start splitAnswers");
        List<String> intentsData = chatbotAnswerDb.returnIntents();
        List<String> answersData = chatbotAnswerDb.returnAnswers();
        List<Chatbot> chatbotsList = new ArrayList<>();

        // 데이터 저장
        for(String intentData: intentsData) {
            for(String answerData : answersData) {
                chatbot = Chatbot.builder()
                        .chatbot_intent(intentData)
                        .chatbot_answer(answerData)
                        .build();
                chatbotsList.add(chatbot);
            }
        }
        chatbotRepository.saveAll(chatbotsList);
    }

}
