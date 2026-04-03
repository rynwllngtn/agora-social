package dev.rynwllngtn.agorasystem.repositories.comment;

import dev.rynwllngtn.agorasystem.dtos.post.PostCommentDTO;
import dev.rynwllngtn.agorasystem.dtos.profile.ProfilePostDTO;
import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    @Query(value = "{ 'post._id' : ?0 }", fields = "{ '_id': 1, 'body': 1 }")
    public List<PostCommentDTO> findCommentsByPostId(String id);

}