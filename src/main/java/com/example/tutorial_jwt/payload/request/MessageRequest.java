package com.example.tutorial_jwt.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MessageRequest {
    @NotBlank
    private String message;
    @NotNull
    private Long messageId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

}