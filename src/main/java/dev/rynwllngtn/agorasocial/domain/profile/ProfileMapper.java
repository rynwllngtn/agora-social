package dev.rynwllngtn.agorasocial.domain.profile;

import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    public ProfileResponseDTO toResponseDTO(Profile profile) {
        return new ProfileResponseDTO(profile.getId(),
                                      profile.getUserName(),
                                      profile.getBirthDate(),
                                      profile.isActive());
    }

    public Profile toEntity(ProfileCreateRequestDTO createRequestDTO) {
        return new Profile(createRequestDTO.profileOwner(),
                           createRequestDTO.userName(),
                           createRequestDTO.birthDate());
    }

}