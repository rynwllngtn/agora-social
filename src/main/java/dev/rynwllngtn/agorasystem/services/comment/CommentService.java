package dev.rynwllngtn.agorasystem.services.comment;

import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    public List<Comment> findAll();

    public Comment findById(String id);

    public Comment insert(Comment comment);

    public void delete(String id);

    public Comment update(String id, Comment comment);

}