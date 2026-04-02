package dev.rynwllngtn.agorasystem.services.post;

import dev.rynwllngtn.agorasystem.dtos.profile.PostAddressDTO;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public List<Post> findAll();

    public Post findById(String id);

    public Post insert(Post post);

    public void delete(String id);

    public Post update(String id, Post post);

    public List<PostAddressDTO> findPostsByAuthorId(String id);

}