package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void addElement(Resume resume, int index) {
        int posIndex = Math.abs(index);
        if (storage[posIndex - 1] != null) {
            System.arraycopy(storage, posIndex - 1, storage, posIndex, size - posIndex + 1);
        }
        storage[posIndex - 1] = resume;
    }

    @Override
    protected void fillPosition(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }

    @Override
    protected int findIndex(String uuid) {
        Resume key = new Resume();
        key.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, key);
    }
}
