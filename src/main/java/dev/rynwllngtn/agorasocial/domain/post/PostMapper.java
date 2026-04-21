package dev.rynwllngtn.agorasocial.domain.post;

import dev.rynwllngtn.agorasocial.domain.post.dto.PostCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.post.dto.PostResponseDTO;
import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileReferenceDTO;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostResponseDTO toResponseDTO(Post post) {
        return new PostResponseDTO(post.getId(),
                                   post.getDate(),
                                   post.getTitle(),
                                   post.getBody());
    }

    public Post toEntity(PostCreateRequestDTO createRequestDTO, ProfileReferenceDTO author) {
        return new Post(author,
                        createRequestDTO.title(),
                        createRequestDTO.body());
    }

}