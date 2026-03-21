package dev.rynwllngtn.agorasystem.exceptions.database;

import java.util.UUID;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }

    public static class ObjectNotFoundException extends DatabaseException {
        public ObjectNotFoundException(UUID id) {
            super("Usuário com ID: " + id + " não foi encontrado no sistema!");
        }
    }
}
