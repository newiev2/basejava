package com.bulavin.webapp.storage;

import com.bulavin.webapp.exception.ExistsStorageException;
import com.bulavin.webapp.exception.NotExistsStorageException;
import com.bulavin.webapp.exception.StorageException;
import com.bulavin.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected final static int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public final int getSize() {
        return size;
    }

    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public final void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (size == STORAGE_LIMIT) {
            throw new StorageException(resume.getUuid(), "Storage is out of capacity");
        } else if (index >= 0) {
            throw new ExistsStorageException(resume.getUuid());
        } else {
            addElement(resume, index);
            size++;
        }
    }

    public final Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistsStorageException(uuid);
        }
        return storage[index];
    }

    public final void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistsStorageException(resume.getUuid());
        } else {
            storage[index] = resume;
        }
    }

    public final void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistsStorageException(uuid);
        } else {
            fillPosition(index);
            size--;
        }
    }

    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract void addElement(Resume resume, int index);

    protected abstract void fillPosition(int index);

    protected abstract int findIndex(String uuid);
}
