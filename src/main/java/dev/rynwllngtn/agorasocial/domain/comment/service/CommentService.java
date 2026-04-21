package dev.rynwllngtn.agorasocial.domain.comment.service;

import dev.rynwllngtn.agorasocial.domain.comment.dto.CommentCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.comment.dto.CommentResponseDTO;
import dev.rynwllngtn.agorasocial.domain.comment.Comment;

public interface CommentService {

    Comment findById(String id);
    CommentResponseDTO getResponseById(String id);

    CommentResponseDTO insert(CommentCreateRequestDTO createRequestDTO);

}