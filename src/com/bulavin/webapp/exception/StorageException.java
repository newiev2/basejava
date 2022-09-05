package com.bulavin.webapp.exception;

public class StorageException extends RuntimeException {
    private final String uuid;

    public StorageException(String message) {
        super(message);
        uuid = null;
    }

    public StorageException(String uuid, String message) {
        super(message);
        this.uuid = uuid;
    }

    public StorageException(String uuid, String message, Exception cause) {
        super(message, cause);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
