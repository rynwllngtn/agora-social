package dev.rynwllngtn.agorasocial.domain.profile.dto;

import java.time.LocalDate;

public record ProfileResponseDTO(
        String id,
        String userName,
        LocalDate birthDate,
        boolean active
) {}