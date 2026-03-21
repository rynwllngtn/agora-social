package dev.rynwllngtn.agorasystem.entities.user;

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
public class User {

    @EqualsAndHashCode.Include
    @Id
    protected UUID id;
    protected String cpf;
    protected String password;
    protected String name;
    protected String email;
    protected Date birthDate;
    protected boolean isActive;

    @Override
    public String toString() {

        if (isActive) {
            return ("ID: " + id + "\n" +
                    "CPF: " + cpf + "\n" +
                    "Password: " + password + "\n" +
                    "Name: " + name + "\n" +
                    "Email: " + email + "\n" +
                    "Birthdate: " + birthDate);
        }

        return "Esse usuário está com a conta desativada!";
    }
}