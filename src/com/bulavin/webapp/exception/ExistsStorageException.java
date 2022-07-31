package com.bulavin.webapp.exception;

public class ExistsStorageException extends StorageException {

    public ExistsStorageException(String uuid) {
        super(uuid, "Resume with uuid " + uuid + " already exists");
    }
}
