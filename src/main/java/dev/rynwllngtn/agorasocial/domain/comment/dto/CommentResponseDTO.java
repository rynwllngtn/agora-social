package dev.rynwllngtn.agorasocial.domain.comment.dto;

import java.time.Instant;

public record CommentResponseDTO(
        String id,
        Instant date,
        String body
) {}