package com.example.tutorial_jwt.controller;

import javax.validation.Valid;

import com.example.tutorial_jwt.models.Message;
import com.example.tutorial_jwt.payload.request.MessageRequest;
import com.example.tutorial_jwt.payload.response.MessageResponse;
import com.example.tutorial_jwt.repository.MessageRepository;
import com.example.tutorial_jwt.repository.RoleRepository;
import com.example.tutorial_jwt.repository.UserRepository;
import com.example.tutorial_jwt.security.jwt.JwtUtils;
import com.example.tutorial_jwt.security.services.MessageDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/create")
public class MessageController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    MessageDetailsServiceImpl messageDetailsService;
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/sendmessage")
    public ResponseEntity<?> sendMessage(@Valid @RequestBody MessageRequest messageRequest) {

        Message message = new Message(messageRequest.getMessage(), messageRequest.getMessageId());

        messageRepository.save(message);

        return ResponseEntity.ok(new MessageResponse("Message saved successfully!"));
    }

    @GetMapping("/getmessage")
    public ResponseEntity<?> getMessage(@RequestHeader(value = "Authorization") String token) {
        System.out.println("2222");
        Optional<Message> mes = messageDetailsService.findMessageFromToken(token.substring(7));
        System.out.println("3333");
        return ResponseEntity.ok(new MessageResponse("Message for id is " + mes.get().getMessage()));
    }
}
