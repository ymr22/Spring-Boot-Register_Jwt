package com.example.tutorial_jwt.repository;

import com.example.tutorial_jwt.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<Message> findByMessageId(Long messageId);

}
