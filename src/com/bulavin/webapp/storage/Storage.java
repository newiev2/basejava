package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

public interface Storage {

    int getSize();

    void clear();

    void save(Resume resume);

    Resume get(String uuid);

    void update(Resume resume, String uuid);

    void delete(String uuid);

    Resume[] getAll();
}
