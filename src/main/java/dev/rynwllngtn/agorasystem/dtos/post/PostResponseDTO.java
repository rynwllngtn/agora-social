package dev.rynwllngtn.agorasystem.dtos.post;

import dev.rynwllngtn.agorasystem.entities.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseDTO {

    private Instant date;
    private String title;
    private String body;

    public PostResponseDTO(Post post) {
        date = post.getDate();
        title = post.getTitle();
        body = post.getBody();
    }

}