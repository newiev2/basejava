package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void addElement(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected void fillPosition(int index) {
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
    }

    @Override
    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
