package com.example.chatbotproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Path {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 30)
    private String directory_name;

    @Column(length = 150)
    private String directory_path;
}
