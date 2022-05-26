package com.example.tutorial_jwt.security.services;

import com.example.tutorial_jwt.models.Message;
import com.example.tutorial_jwt.repository.MessageRepository;
import com.example.tutorial_jwt.repository.UserRepository;
import com.example.tutorial_jwt.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MessageDetailsServiceImpl {
    @Autowired
    MessageRepository messageRepository;
    @Autowired JwtUtils jwtUtils;
    @Autowired
    UserRepository userRepository;

    public Optional<Message> findMessageFromToken(String token) throws UsernameNotFoundException {
        System.out.println("1111");
        Long id = userRepository.findByUsername(jwtUtils.getUserNameFromJwtToken(token)).get().getId();
        return messageRepository.findByMessageId(id);
    }

}
