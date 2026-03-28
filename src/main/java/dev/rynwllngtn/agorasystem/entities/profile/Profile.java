package dev.rynwllngtn.agorasystem.entities.profile;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class Profile {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private UUID profileOwner;
    private String userName;
    private Date birthDate;
    private boolean isActive = true;

    @Override
    public String toString() {

        if (isActive) {
            return ("ID: " + id + "\n" +
                    "Profile Owner: " + profileOwner + "\n" +
                    "Name: " + userName + "\n" +
                    "Birthdate: " + birthDate);
        }

        return "Esse profile está desativado!";
    }

}