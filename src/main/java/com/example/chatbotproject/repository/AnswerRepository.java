package com.example.chatbotproject.repository;

import com.example.chatbotproject.entity.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answers, Long> {

    Answers findByIntent(String intent);
}
