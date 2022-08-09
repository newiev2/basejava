package com.bulavin.webapp.storage;

import com.bulavin.webapp.exception.StorageException;
import com.bulavin.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected final static int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected static int size;

    @Override
    protected void saveResume(Resume resume, Object index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException(resume.getUuid(), "Storage is out of capacity");
        } else {
            addElement(resume, (Integer) index);
            size++;
        }
    }

    @Override
    protected Resume getResume(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected void updateResume(Resume resume, Object index) {
        storage[(Integer) index] = resume;
    }

    @Override
    protected void deleteResume(Object index) {
        fillPosition((Integer) index);
        size--;
    }

    @Override
    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public final int size() {
        return size;
    }

    @Override
    protected boolean isExisting(Object index) {
        return (Integer) index >= 0;
    }

    protected abstract Integer findSearchKey(String uuid);

    protected abstract void addElement(Resume resume, int index);

    protected abstract void fillPosition(int index);
}
