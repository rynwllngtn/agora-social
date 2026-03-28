package dev.rynwllngtn.agorasystem.repositories.profile;

import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {
}