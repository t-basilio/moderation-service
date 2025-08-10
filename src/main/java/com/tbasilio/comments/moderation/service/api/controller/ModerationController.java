package com.tbasilio.comments.moderation.service.api.controller;

import com.tbasilio.comments.moderation.service.api.model.ModerationInput;
import com.tbasilio.comments.moderation.service.api.model.ModerationOutput;
import com.tbasilio.comments.moderation.service.domain.service.ModerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/moderate")
@RequiredArgsConstructor
public class ModerationController {

    private final ModerationService service;

    @PostMapping
    public ModerationOutput moderate(@RequestBody ModerationInput input) {
        return service.moderate(input.getText());
    }
}
