package dev.rynwllngtn.agorasystem.controllers.comment;

import dev.rynwllngtn.agorasystem.entities.comment.Comment;
import dev.rynwllngtn.agorasystem.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> findAll() {
        List<Comment> comments = commentService.findAll();
        return ResponseEntity.ok().body(comments);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Comment> findById(@PathVariable String id) {
        Comment comment = commentService.findById(id);
        return ResponseEntity.ok().body(comment);
    }

    @PostMapping
    public ResponseEntity<Comment> insert(@RequestBody Comment comment) {
        comment = commentService.insert(comment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comment.getId()).toUri();
        return ResponseEntity.created(uri).body(comment);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Comment> update(@RequestBody Comment comment, @PathVariable String id) {
        comment = commentService.update(id, comment);
        return ResponseEntity.ok().body(comment);
    }

}