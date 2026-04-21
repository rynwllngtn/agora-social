package dev.rynwllngtn.agorasocial.domain.comment.service;

import dev.rynwllngtn.agorasocial.domain.comment.Comment;
import dev.rynwllngtn.agorasocial.domain.comment.CommentMapper;
import dev.rynwllngtn.agorasocial.domain.comment.CommentRepository;
import dev.rynwllngtn.agorasocial.domain.comment.dto.CommentCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.comment.dto.CommentResponseDTO;
import dev.rynwllngtn.agorasocial.domain.post.dto.PostReferenceDTO;
import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileReferenceDTO;
import dev.rynwllngtn.agorasocial.infrastructure.exceptions.database.DatabaseException.ObjectNotFoundException;
import dev.rynwllngtn.agorasocial.domain.post.service.PostService;
import dev.rynwllngtn.agorasocial.domain.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentServiceImplementation implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    private final ProfileService profileService;
    private final PostService postService;

    @Override
    public Comment findById(String id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElseThrow(
                () -> new ObjectNotFoundException(Comment.class, id));
    }

    @Override
    public CommentResponseDTO getResponseById(String id) {
        Optional<CommentResponseDTO> responseDTO = commentRepository.getResponseById(id);
        return responseDTO.orElseThrow(
                () -> new ObjectNotFoundException(Comment.class, id));
    }

    @Override
    public CommentResponseDTO insert(CommentCreateRequestDTO createRequestDTO) {
        ProfileReferenceDTO profileReferenceDTO = profileService.getReferenceById(createRequestDTO.author());
        PostReferenceDTO postReferenceDTO = postService.getReferenceById(createRequestDTO.post());
        Comment comment = commentMapper.toEntity(createRequestDTO,
                                                 profileReferenceDTO,
                                                 postReferenceDTO);

        comment = commentRepository.save(comment);
        return commentMapper.toResponseDTO(comment);
    }

}