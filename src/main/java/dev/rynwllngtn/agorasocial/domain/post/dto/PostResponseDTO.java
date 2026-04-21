package dev.rynwllngtn.agorasocial.domain.post.dto;

import java.time.Instant;

public record PostResponseDTO(
        String id,
        Instant date,
        String title,
        String body
) {}