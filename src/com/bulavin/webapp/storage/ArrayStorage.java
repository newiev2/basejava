package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int index = findIndex(resume.toString());
        if(size == STORAGE_LIMIT) {
            System.out.println("Storage is out of capacity");
        } else if(index > -1) {
            System.out.println("Resume with uuid " + resume + " already exists");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    @Override
    public void update(String targetUuid, String newUuid) {
        int index = findIndex(targetUuid);
        if(index == -1) {
            System.out.println("Resume with uuid " + targetUuid + " does not exist");
        } else {
            storage[index].setUuid(newUuid);
        }
    }

    @Override
    public void delete(String uuid) {
        int index = findIndex(uuid);
        if(index == -1) {
            System.out.println("Resume with uuid " + uuid + " does not exist");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    protected int findIndex(String uuid)  {
        for(int i = 0; i < size; i++) {
            if(storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
