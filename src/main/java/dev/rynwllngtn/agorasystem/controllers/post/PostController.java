package dev.rynwllngtn.agorasystem.controllers.post;

import dev.rynwllngtn.agorasystem.dtos.post.PostCommentDTO;
import dev.rynwllngtn.agorasystem.dtos.post.PostDTO;
import dev.rynwllngtn.agorasystem.entities.post.Post;
import dev.rynwllngtn.agorasystem.services.comment.CommentService;
import dev.rynwllngtn.agorasystem.services.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        PostDTO postDTO = postService.findById(id);
        return ResponseEntity.ok().body(postDTO);
    }

    @PostMapping
    public ResponseEntity<PostDTO> insert(@RequestBody Post post) {
        post = postService.insert(post);
        PostDTO postDTO = postService.findById(post.getId());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(uri).body(postDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PostDTO> update(@RequestBody PostDTO postDTO, @PathVariable String id) {
        postService.update(id, postDTO);
        return ResponseEntity.ok().body(postDTO);
    }

    @GetMapping(value = "/{id}/comments")
    public ResponseEntity<List<PostCommentDTO>> findAllComments(@PathVariable String id) {
        List<PostCommentDTO> comments = commentService.findCommentsByPostId(id);
        return ResponseEntity.ok().body(comments);
    }

}