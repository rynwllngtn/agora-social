package dev.rynwllngtn.agorasystem.entities.post;

import dev.rynwllngtn.agorasystem.dtos.post.AuthorDTO;
import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Date date;
    private String title;
    private String body;

    public void update(Post data) {
        title = data.getTitle();
        body = data.getBody();
    }

}