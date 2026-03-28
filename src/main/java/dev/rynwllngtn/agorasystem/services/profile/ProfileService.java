package dev.rynwllngtn.agorasystem.services.profile;

import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfileService {

    public List<Profile> findAll();

    public Profile findById(String id);

    public Profile insert(Profile profile);

    public void delete(String id);

    public Profile update(String id, Profile profile);

}