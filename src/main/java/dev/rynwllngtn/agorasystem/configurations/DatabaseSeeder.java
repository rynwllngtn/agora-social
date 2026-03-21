package dev.rynwllngtn.agorasystem.configurations;

import dev.rynwllngtn.agorasystem.entities.user.User;
import dev.rynwllngtn.agorasystem.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Random;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() > 0) {
            return;
        }

        Random random = new Random();
        for (int i = 1; i <= 50; i++) {

            String cpf = String.format("%011d", random.nextInt(1000000000));
            User user = new User();
            user.setCpf(cpf);
            user.setPassword("password");
            user.setName(String.format("User Number %d", i));
            user.setEmail(String.format("user%d@email.com", i));
            user.setBirthDate(new Date());

            IO.println(userRepository.save(user));

        }
    }

}