package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected void addElement(Resume resume, int index) {
        int posIndex = Math.abs(index) - 1;
        if (storage[posIndex] != null) {
            System.arraycopy(storage, posIndex, storage, posIndex + 1, size - posIndex);
        }
        storage[posIndex] = resume;
    }

    @Override
    protected void fillPosition(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }

    @Override
    protected Integer findSearchKey(String uuid) {
        Resume key = new Resume(uuid, null);
        return Arrays.binarySearch(storage, 0, size, key, RESUME_COMPARATOR);
    }
}
