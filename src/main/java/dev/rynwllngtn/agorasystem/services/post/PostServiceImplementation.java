package dev.rynwllngtn.agorasystem.services.post;

import dev.rynwllngtn.agorasystem.entities.post.Post;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.*;
import dev.rynwllngtn.agorasystem.repositories.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

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
        return postRepository.insert(post);
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