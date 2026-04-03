package dev.rynwllngtn.agorasystem.dtos.post;

import dev.rynwllngtn.agorasystem.dtos.AuthorDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostCreateRequestDTO {

    private AuthorDTO author;
    private String title;
    private String body;

}