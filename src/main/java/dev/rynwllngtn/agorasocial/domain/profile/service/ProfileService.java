package dev.rynwllngtn.agorasocial.domain.profile.service;

import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileCreateRequestDTO;
import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileReferenceDTO;
import dev.rynwllngtn.agorasocial.domain.profile.dto.ProfileResponseDTO;
import dev.rynwllngtn.agorasocial.domain.profile.Profile;

public interface ProfileService {

    Profile findById(String id);
    ProfileReferenceDTO getReferenceById(String id);
    ProfileResponseDTO getResponseById(String id);

    ProfileResponseDTO insert(ProfileCreateRequestDTO createRequestDTO);

}