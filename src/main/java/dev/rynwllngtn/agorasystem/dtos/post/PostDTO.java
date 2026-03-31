package dev.rynwllngtn.agorasystem.dtos.post;

import dev.rynwllngtn.agorasystem.entities.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {

    private String id;
    private AuthorDTO author;
    private String title;

    public PostDTO(Post post) {
        id = post.getId();
        author = post.getAuthor();
        title = post.getTitle();
    }

}