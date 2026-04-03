package dev.rynwllngtn.agorasystem.dtos.post;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostUpdateRequestDTO {

    @NotBlank(message = "Digite um titulo!")
    private String title;

    @NotBlank(message = "Digite um comentário!")
    private String body;

}