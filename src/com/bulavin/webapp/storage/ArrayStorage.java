package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void addElement(Resume resume) {
        storage[size] = resume;
    }

    @Override
    protected void fillPosition(int index) {
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
    }
}
