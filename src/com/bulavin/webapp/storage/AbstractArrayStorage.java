package com.bulavin.webapp.storage;

import com.bulavin.webapp.exception.StorageException;
import com.bulavin.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

    protected final static int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected static int size;

    @Override
    protected void saveResume(Resume resume, Integer index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException(resume.getUuid(), "Storage is out of capacity");
        } else {
            addElement(resume, index);
            size++;
        }
    }

    @Override
    protected Resume getResume(Integer index) {
        return storage[index];
    }

    @Override
    protected void updateResume(Resume resume, Integer index) {
        storage[index] = resume;
    }

    @Override
    protected void deleteResume(Integer index) {
        fillPosition(index);
        size--;
    }

    @Override
    protected List<Resume> getAllElements() {
        Resume[] resumes = Arrays.copyOf(storage, size);
        return Arrays.asList(resumes);
    }

    @Override
    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public final int size() {
        return size;
    }

    @Override
    protected boolean isExisting(Integer index) {
        return  index >= 0;
    }

    protected abstract Integer findSearchKey(String uuid);

    protected abstract void addElement(Resume resume, int index);

    protected abstract void fillPosition(int index);
}
