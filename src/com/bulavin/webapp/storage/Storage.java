package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

public interface Storage {

    int getStorageLimit();

    int getSize();

    void clear();

    void save(Resume resume);

    Resume get(String uuid);

    void update(Resume resume);

    void delete(String uuid);

    Resume[] getAll();
}
