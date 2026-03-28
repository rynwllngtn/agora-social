package dev.rynwllngtn.agorasystem.exceptions.database;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }

    public static class ObjectNotFoundException extends DatabaseException {
        public ObjectNotFoundException(String id) {
            super("Usuário com ID: " + id + " não foi encontrado no sistema!");
        }
    }

    public static class ObjectConstrainException extends DatabaseException {
        public ObjectConstrainException(String id) {
            super(id);
        }
    }

}