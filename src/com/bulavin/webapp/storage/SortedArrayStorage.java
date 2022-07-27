package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void addElement(Resume resume) {
        int index = Math.abs(findIndex(resume.getUuid()));
        if(storage[index - 1] != null) {
            System.arraycopy(storage, index - 1, storage, index, size - index + 1);
        }
        storage[index - 1] = resume;
    }

    @Override
    protected void fillPosition(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }
}
