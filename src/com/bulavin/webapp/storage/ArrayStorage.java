package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final static int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size;

    public int getSize() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage,0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if(size == STORAGE_LIMIT) {
            System.out.println("Storage is out of capacity");
        } else if(findIndex(resume.toString()) > -1) {
            System.out.println("com.bulavin.webapp.model.Resume with uuid " + resume.toString() + " already exists");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        if(findIndex(uuid) == -1) {
            System.out.println("com.bulavin.webapp.model.Resume with uuid " + uuid + " does not exist");
            return null;
        }
        return storage[findIndex(uuid)];
    }

    public void update(String targetUuid, String newUuid) {
        if(findIndex(targetUuid) == -1) {
            System.out.println("com.bulavin.webapp.model.Resume with uuid " + targetUuid + " does not exist");
        } else {
            storage[findIndex(targetUuid)].setUuid(newUuid);
        }
    }

    public void delete(String uuid) {
        if(findIndex(uuid) == -1) {
            System.out.println("com.bulavin.webapp.model.Resume with uuid " + uuid + " does not exist");
        } else {
            storage[findIndex(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    private int findIndex(String uuid) {
        for(int i = 0; i < size; i++) {
            if(storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }


}
