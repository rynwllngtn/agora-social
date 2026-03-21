package dev.rynwllngtn.agorasystem.repositories.user;

import dev.rynwllngtn.agorasystem.entities.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
}