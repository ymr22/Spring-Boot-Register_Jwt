package com.example.tutorial_jwt.payload.request;

import javax.validation.constraints.NotNull;

public class GetMessageRequest {
    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    @NotNull
    private Long messageId;
}
