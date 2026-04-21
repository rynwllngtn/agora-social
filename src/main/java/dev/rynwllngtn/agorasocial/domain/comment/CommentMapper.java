package dev.rynwllngtn.agorasocial.domain.comment;

import dev.rynwllngtn.agorasocial.domain.comment.dto.CommentCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.comment.dto.CommentResponseDTO;
import dev.rynwllngtn.agorasocial.domain.post.dto.PostReferenceDTO;
import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileReferenceDTO;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentResponseDTO toResponseDTO(Comment comment) {
        return new CommentResponseDTO(comment.getId(),
                                      comment.getDate(),
                                      comment.getBody());
    }

    public Comment toEntity(CommentCreateRequestDTO createRequestDTO,
                            ProfileReferenceDTO author,
                            PostReferenceDTO post) {

        return new Comment(author,
                           post,
                           createRequestDTO.body());
    }

}