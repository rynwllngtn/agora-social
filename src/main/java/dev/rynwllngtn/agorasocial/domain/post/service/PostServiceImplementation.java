package dev.rynwllngtn.agorasocial.domain.post.service;

import dev.rynwllngtn.agorasocial.domain.post.Post;
import dev.rynwllngtn.agorasocial.domain.post.PostMapper;
import dev.rynwllngtn.agorasocial.domain.post.PostRepository;
import dev.rynwllngtn.agorasocial.domain.post.dto.PostCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.post.dto.PostReferenceDTO;
import dev.rynwllngtn.agorasocial.domain.post.dto.PostResponseDTO;
import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileReferenceDTO;
import dev.rynwllngtn.agorasocial.infrastructure.exceptions.database.DatabaseException.ObjectNotFoundException;
import dev.rynwllngtn.agorasocial.domain.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostServiceImplementation implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final ProfileService profileService;

    @Override
    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(
                () -> new ObjectNotFoundException(Post.class, id));
    }

    @Override
    public PostReferenceDTO getReferenceById(String id) {
        Optional<PostReferenceDTO> postReferenceDTO = postRepository.getReferenceById(id);
        return postReferenceDTO.orElseThrow(
                () -> new ObjectNotFoundException(Post.class, id));
    }

    @Override
    public PostResponseDTO getResponseById(String id) {
        Optional<PostResponseDTO> postResponseDTO = postRepository.getResponseById(id);
        return postResponseDTO.orElseThrow(
                () -> new ObjectNotFoundException(Post.class, id));
    }

    @Override
    public PostResponseDTO insert(PostCreateRequestDTO createRequestDTO) {
        ProfileReferenceDTO referenceDTO = profileService.getReferenceById(createRequestDTO.author());
        Post post = postMapper.toEntity(createRequestDTO,
                                        referenceDTO);

        post = postRepository.save(post);
        return postMapper.toResponseDTO(post);
    }

}