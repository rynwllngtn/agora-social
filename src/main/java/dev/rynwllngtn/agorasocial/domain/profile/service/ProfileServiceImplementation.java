package dev.rynwllngtn.agorasocial.domain.profile.service;

import dev.rynwllngtn.agorasocial.domain.profile.Profile;
import dev.rynwllngtn.agorasocial.domain.profile.ProfileMapper;
import dev.rynwllngtn.agorasocial.domain.profile.ProfileRepository;
import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileReferenceDTO;
import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileResponseDTO;
import dev.rynwllngtn.agorasocial.infrastructure.exceptions.database.DatabaseException.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfileServiceImplementation implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    @Override
    public Profile findById(String id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.orElseThrow(
                () -> new ObjectNotFoundException(Profile.class, id));
    }

    @Override
    public ProfileReferenceDTO getReferenceById(String id) {
        Optional<ProfileReferenceDTO> profileReferenceDTO = profileRepository.getReferenceById(id);
        return profileReferenceDTO.orElseThrow(
                () -> new ObjectNotFoundException(Profile.class, id));
    }

    @Override
    public ProfileResponseDTO getResponseById(String id) {
        Optional<ProfileResponseDTO> profileResponseDTO = profileRepository.getResponseById(id);
        return profileResponseDTO.orElseThrow(
                () -> new ObjectNotFoundException(Profile.class, id));
    }

    @Override
    public ProfileResponseDTO insert(ProfileCreateRequestDTO createRequestDTO) {
        Profile profile = profileMapper.toEntity(createRequestDTO);
        profile = profileRepository.save(profile);
        return profileMapper.toResponseDTO(profile);
    }

}