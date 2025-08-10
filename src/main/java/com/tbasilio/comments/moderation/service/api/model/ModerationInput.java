package com.tbasilio.comments.moderation.service.api.model;

import lombok.Data;
import java.util.UUID;

@Data
public class ModerationInput {
    private UUID commentId;
    private String text;
}
