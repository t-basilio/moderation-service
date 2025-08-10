package com.tbasilio.comments.moderation.service.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModerationOutput {
    private Boolean approved;
    private String reason;
}
