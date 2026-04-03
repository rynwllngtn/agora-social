package dev.rynwllngtn.agorasystem.dtos.post;

import dev.rynwllngtn.agorasystem.entities.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {

    private Instant date;
    private String title;
    private String body;

    public PostDTO(Post post) {
        title = post.getTitle();
        body = post.getBody();
    }

}