package dev.rynwllngtn.agorasystem.services.profile;

import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ObjectConstrainException;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ObjectNotFoundException;
import dev.rynwllngtn.agorasystem.repositories.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImplementation implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile findById(String id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.orElseThrow(() -> new ObjectNotFoundException(Profile.class, id));
    }

    @Override
    public Profile insert(Profile profile) {

        try {
            return profileRepository.insert(profile);
        }
        catch (DuplicateKeyException e) {
            throw new ObjectConstrainException(e.getMessage());
        }
    }

    @Override
    public void delete(String id) {

        if (!profileRepository.existsById(id)) {
            throw new ObjectNotFoundException(Profile.class, id);
        }

        profileRepository.deleteById(id);
    }

    @Override
    public Profile update(String id, Profile data) {
        Profile profile = findById(id);
        profile.update(data);
        return profileRepository.save(profile);
    }

}