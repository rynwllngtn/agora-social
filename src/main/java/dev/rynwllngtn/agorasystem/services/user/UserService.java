package dev.rynwllngtn.agorasystem.services.user;

import dev.rynwllngtn.agorasystem.entities.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> findAll();

}