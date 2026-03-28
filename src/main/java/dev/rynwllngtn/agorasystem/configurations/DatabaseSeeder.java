package dev.rynwllngtn.agorasystem.configurations;

import dev.rynwllngtn.agorasystem.entities.profile.Profile;
import dev.rynwllngtn.agorasystem.repositories.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public void run(String... args) throws Exception {

        if (profileRepository.count() > 0) {
            return;
        }

        for (int i = 1; i <= 50; i++) {
            Profile profile = new Profile();
            profile.setProfileOwner(UUID.randomUUID());
            profile.setUserName(String.format("User Number %d", i));
            profile.setBirthDate(new Date());

            IO.println(profileRepository.save(profile));

        }
    }

}