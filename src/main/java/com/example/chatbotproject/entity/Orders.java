package com.example.chatbotproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int count;

    @Column
    private boolean delivery;

    @Column(length = 50)
    private String address;

    // 메뉴 의도
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_NAME")
    private Menu menu;
}
