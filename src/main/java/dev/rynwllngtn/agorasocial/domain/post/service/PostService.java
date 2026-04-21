package dev.rynwllngtn.agorasocial.domain.post.service;

import dev.rynwllngtn.agorasocial.domain.post.dto.PostCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.post.dto.PostReferenceDTO;
import dev.rynwllngtn.agorasocial.domain.post.dto.PostResponseDTO;
import dev.rynwllngtn.agorasocial.domain.post.Post;

public interface PostService {

    Post findById(String id);
    PostReferenceDTO getReferenceById(String id);
    PostResponseDTO getResponseById(String id);

    PostResponseDTO insert(PostCreateRequestDTO createRequestDTO);

}