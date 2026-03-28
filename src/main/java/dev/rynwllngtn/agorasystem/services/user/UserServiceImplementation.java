package dev.rynwllngtn.agorasystem.services.user;

import dev.rynwllngtn.agorasystem.entities.user.User;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.*;
import dev.rynwllngtn.agorasystem.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    @Override
    public User insert(User user) {
        return userRepository.insert(user);
    }

    @Override
    public void delete(String id) {

        if (!userRepository.existsById(id)) {
            throw new ObjectNotFoundException(id);
        }

        try {
            userRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new ObjectConstrainException(e.getMessage());
        }
    }

    @Override
    public User update(String id, User user) {
        return null;
    }

}