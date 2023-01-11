package com.example.chatbotproject.repository;

import com.example.chatbotproject.entity.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathRepository extends JpaRepository<Path, String> {
}
