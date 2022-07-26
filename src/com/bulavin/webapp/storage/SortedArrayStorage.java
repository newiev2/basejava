package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if(size == STORAGE_LIMIT) {
            System.out.println("Storage is out of capacity");
        } else if(index >= 0) {
            System.out.println("Resume with uuid " + resume + " already exists");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    @Override
    public void update(String targetUuid, String newUuid) {
        int index = findIndex(targetUuid);
        if(index < 0) {
            System.out.println("Resume with uuid " + targetUuid + " does not exist");
        } else {
            storage[index].setUuid(newUuid);
        }
    }

    @Override
    public void delete(String uuid) {
        int index = findIndex(uuid);
        if(index < 0) {
            System.out.println("Resume with uuid " + uuid + " does not exist");
        } else {
            System.arraycopy(storage, index + 1, storage, index, size - index);
            size--;
        }
    }

    @Override
    protected int findIndex(String uuid) {
        Resume key = new Resume();
        key.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, key);
    }
}
