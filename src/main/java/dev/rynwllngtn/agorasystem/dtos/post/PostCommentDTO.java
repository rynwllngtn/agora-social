package dev.rynwllngtn.agorasystem.dtos.post;

import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostCommentDTO {

    private String id;
    private String body;

    public PostCommentDTO(Comment comment) {
        id = comment.getId();
        body = comment.getBody();
    }

}