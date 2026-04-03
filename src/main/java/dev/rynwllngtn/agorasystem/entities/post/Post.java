package dev.rynwllngtn.agorasystem.entities.post;

import dev.rynwllngtn.agorasystem.dtos.AuthorDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostDTO;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class Post {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private AuthorDTO author;

    @CreatedDate
    private Instant date;
    private String title;
    private String body;

    public void update(PostDTO postDTO) {
        title = postDTO.getTitle();
        body = postDTO.getBody();
    }

}