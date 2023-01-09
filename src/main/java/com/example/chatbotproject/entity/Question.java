package com.example.chatbotproject.entity;

import lombok.Builder;

import javax.persistence.*;

@Entity
public class Question {//id intent questions(데이터 원본 저장)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  insert에 pk가 빠지고 데이터베이스의 auto_increment 동작이 수행
    private Long id;
    @Column(nullable = false)
    private String intent;
    @Column(nullable = false)
    private String questions;

    @Builder
    public Question(String intent, String questions) {
        this.intent = intent;
        this.questions = questions;
    }
}
