package dev.rynwllngtn.agorasystem.services.comment;

import dev.rynwllngtn.agorasystem.dtos.AuthorDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostCommentDTO;
import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ObjectConstrainException;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ObjectNotFoundException;
import dev.rynwllngtn.agorasystem.repositories.comment.CommentRepository;
import dev.rynwllngtn.agorasystem.services.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(String id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElseThrow(() -> new ObjectNotFoundException(Comment.class, id));
    }

    @Override
    public Comment insert(Comment comment) {

        try {
            AuthorDTO author = profileService.findAuthorById(comment.getAuthor().getId());
            comment.setAuthor(author);
            comment.setDate(new Date());
            return commentRepository.insert(comment);
        }
        catch (DuplicateKeyException e) {
            throw new ObjectConstrainException(e.getMessage());
        }
    }

    @Override
    public void delete(String id) {

        if (!commentRepository.existsById(id)) {
            throw new ObjectNotFoundException(Comment.class, id);
        }

        commentRepository.deleteById(id);
    }

    @Override
    public Comment update(String id, Comment data) {
        Comment comment = findById(id);
        comment.update(data);
        return commentRepository.save(comment);
    }

    @Override
    public List<PostCommentDTO> findCommentsByPostId(String id) {
        return commentRepository.findCommentsByPostId(id);
    }

}