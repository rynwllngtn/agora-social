package dev.rynwllngtn.agorasocial.domain.comment;

import dev.rynwllngtn.agorasocial.domain.post.dto.PostReferenceDTO;
import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileReferenceDTO;
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
@Document(collection = "comments")
public class Comment {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private ProfileReferenceDTO author;
    private PostReferenceDTO post;

    @CreatedDate
    private Instant date;
    private String body;

    public Comment(ProfileReferenceDTO author, PostReferenceDTO post, String body) {
        this.author = author;
        this.post = post;
        this.body = body;
    }


}