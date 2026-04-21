package dev.rynwllngtn.agorasocial.domain.comment.dto;

import jakarta.validation.constraints.NotBlank;

public record CommentCreateRequestDTO(
        @NotBlank(message = "ID de autor não pode ser vázio ou null!")
        String author,
        @NotBlank(message = "ID de post não pode ser vázio ou null!")
        String post,
        @NotBlank(message = "Comentário não pode ser vázio ou null!")
        String body
) {}