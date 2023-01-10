package com.example.chatbotproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Answers {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String intent;

    @Column(length = 100, nullable = false)
    private String answer;

    @Builder
    public Answers(Long id, String intent, String answer) {
        this.id = id;
        this.intent = intent;
        this.answer = answer;
    }
}
