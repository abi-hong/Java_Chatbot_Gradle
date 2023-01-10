package com.example.chatbotproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 30)
    private String menu_intent;

    @Column
    private int price;

    @Column(length = 30)
    private String menu_name;
}
