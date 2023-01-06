package com.example.chatbotproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Chatbot {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String chatbot_intent;

    @Column(length = 100, nullable = false)
    private String chatbot_answer;

    @Builder
    public Chatbot(Long id, String chatbot_intent, String chatbot_answer) {
        this.id = id;
        this.chatbot_intent = chatbot_intent;
        this.chatbot_answer = chatbot_answer;
    }
}
