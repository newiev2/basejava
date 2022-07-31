package com.bulavin.webapp.exception;

public class NotExistsStorageException extends StorageException {

    public NotExistsStorageException(String uuid) {
        super(uuid, "Resume with uuid " + uuid + " does not exists");
    }
}
