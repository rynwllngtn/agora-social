package dev.rynwllngtn.agorasystem.services.comment;

import dev.rynwllngtn.agorasystem.dtos.post.AuthorDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostDTO;
import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.*;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ObjectNotFoundException;
import dev.rynwllngtn.agorasystem.repositories.comment.CommentRepository;
import dev.rynwllngtn.agorasystem.services.post.PostService;
import dev.rynwllngtn.agorasystem.services.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ProfileService profileService;

    @Autowired
    PostService postService;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(String id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElseThrow(() -> new ObjectNotFoundException(Comment.class.getSimpleName(), id));
    }

    @Override
    public Comment insert(Comment comment) {

        Profile profile = profileService.findById(comment.getAuthor().getId());
        AuthorDTO author = new AuthorDTO(profile);
        comment.setAuthor(author);
        comment.setDate(new Date());

        Post post = postService.findById(comment.getPost().getId());
        PostDTO postDTO = new PostDTO(post);
        comment.setPost(postDTO);

        return commentRepository.insert(comment);
    }

    @Override
    public void delete(String id) {

        if (!commentRepository.existsById(id)) {
            throw new ObjectNotFoundException(Comment.class.getSimpleName(), id);
        }

        try {
            commentRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new ObjectConstrainException(e.getMessage());
        }
    }

    @Override
    public Comment update(String id, Comment data) {
        Comment comment = findById(id);
        updateData(comment, data);
        return commentRepository.save(comment);
    }

    private void updateData(Comment comment, Comment data) {
        comment.setBody(data.getBody());
        comment.setPost(data.getPost());
        comment.setAuthor(data.getAuthor());
    }

}