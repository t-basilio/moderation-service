package com.tbasilio.comments.moderation.service.domain.service;

public class LoadFileBadWordsException extends RuntimeException {
    public LoadFileBadWordsException(String message) {
        super(message);
    }
}
