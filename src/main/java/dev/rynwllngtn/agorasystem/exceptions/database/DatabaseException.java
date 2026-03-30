package dev.rynwllngtn.agorasystem.exceptions.database;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }

    public static class ObjectNotFoundException extends DatabaseException {
        public ObjectNotFoundException(String entityName, String id) {
            super(String.format("%s com o ID: %s não foi encontrado no sistema!",entityName ,id));
        }
    }

    public static class ObjectConstrainException extends DatabaseException {
        public ObjectConstrainException(String id) {
            super(id);
        }
    }

}