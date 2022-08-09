package com.bulavin.webapp.storage;

import com.bulavin.webapp.exception.ExistsStorageException;
import com.bulavin.webapp.exception.NotExistsStorageException;
import com.bulavin.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public final void save(Resume resume) {
        Object searchKey = findSearchKey(resume.getUuid());
        if (isExisting(searchKey)) {
            throw new ExistsStorageException(resume.getUuid());
        } else {
            saveResume(resume, searchKey);
        }
    }

    public final Resume get(String uuid) {
        Object searchKey = findSearchKey(uuid);
        if (!isExisting(searchKey)) {
            throw new NotExistsStorageException(uuid);
        }
        return getResume(searchKey);
    }

    public final void update(Resume resume) {
        Object searchKey = findSearchKey(resume.getUuid());
        if (!isExisting(searchKey)) {
            throw new NotExistsStorageException(resume.getUuid());
        } else {
            updateResume(resume, searchKey);
        }
    }

    public final void delete(String uuid) {
        Object searchKey = findSearchKey(uuid);
        if (!isExisting(searchKey)) {
            throw new NotExistsStorageException(uuid);
        } else {
            deleteResume(searchKey);
        }
    }

    protected abstract void saveResume(Resume resume, Object searchKey);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void updateResume(Resume resume, Object searchKey);

    protected abstract void deleteResume(Object searchKey);

    protected abstract boolean isExisting(Object searchKey);

    protected abstract Object findSearchKey(String uuid);
}
