package com.example.chatbotproject.repository;

import com.example.chatbotproject.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, String> {
}
