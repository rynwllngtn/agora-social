package dev.rynwllngtn.agorasocial.domain.post;

import dev.rynwllngtn.agorasocial.domain.post.dto.PostReferenceDTO;
import dev.rynwllngtn.agorasocial.domain.post.dto.PostResponseDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface PostRepository extends MongoRepository<Post, String> {

    @Query(value = "{ '_id' : ?0 }", fields = "{ 'date': 1, 'title': 1, 'body': 1 }")
    Optional<PostResponseDTO> getResponseById(String id);

    @Query(value = "{ '_id' : ?0 }", fields = "{ '_id': 1, 'body': 1 }")
    Optional<PostReferenceDTO> getReferenceById(String id);

}