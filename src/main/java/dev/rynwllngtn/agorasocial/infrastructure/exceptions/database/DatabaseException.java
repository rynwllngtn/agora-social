package dev.rynwllngtn.agorasocial.infrastructure.exceptions.database;

import lombok.Getter;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }

    @Getter
    public static class ObjectNotFoundException extends DatabaseException {

        private String className;

        public ObjectNotFoundException(Class<?> className, String id) {
            super(String.format("%s com o ID: %s não foi encontrado no sistema!", className.getSimpleName(),id));
            this.className = className.getSimpleName();
        }

    }

}