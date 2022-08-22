package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

import java.util.List;

public interface Storage {

    void save(Resume resume);

    Resume get(String uuid);

    void update(Resume resume);

    void delete(String uuid);

    void clear();

    List<Resume> getAllSorted();

    int size();
}
