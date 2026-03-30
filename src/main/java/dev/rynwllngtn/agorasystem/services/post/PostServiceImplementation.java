package dev.rynwllngtn.agorasystem.services.post;

import dev.rynwllngtn.agorasystem.dtos.post.AuthorDTO;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.*;
import dev.rynwllngtn.agorasystem.repositories.post.PostRepository;
import dev.rynwllngtn.agorasystem.repositories.profile.ProfileRepository;
import dev.rynwllngtn.agorasystem.services.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProfileService profileService;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    @Override
    public Post insert(Post post) {

        Profile profile = profileService.findById(post.getAuthor().getId());
        AuthorDTO author = new AuthorDTO(profile);
        post.setAuthor(author);
        post.setDate(new Date());
        postRepository.insert(post);

        profile.getPosts().add(post);
        profileService.update(profile.getId(), profile);
        return post;
    }

    @Override
    public void delete(String id) {

        if (!postRepository.existsById(id)) {
            throw new ObjectNotFoundException(id);
        }

        try {
            postRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new ObjectConstrainException(e.getMessage());
        }
    }

    @Override
    public Post update(String id, Post data) {
        Post post = findById(id);
        updateData(post, data);
        return postRepository.save(post);
    }

    private void updateData(Post post, Post data) {
        post.setAuthor(data.getAuthor());
        post.setTitle(data.getTitle());
        post.setBody(data.getBody());
    }

}