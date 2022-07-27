package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected final static int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public final int getSize() {
        return size;
    }

    public final void clear() {
        Arrays.fill(storage,0, size, null);
        size = 0;
    }

    public final void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if(size == STORAGE_LIMIT) {
            System.out.println("Storage is out of capacity");
        } else if(index >= 0) {
            System.out.println("Resume with uuid " + resume + " already exists");
        } else {
            addElement(resume);
            size++;
        }
    }

    protected abstract void addElement(Resume resume);

    public final Resume get(String uuid) {
        int index = findIndex(uuid);
        if(index < 0) {
            System.out.println("Resume with uuid " + uuid + " does not exist");
            return null;
        }
        return storage[index];
    }

    public final void update(String targetUuid, String newUuid) {
        int index = findIndex(targetUuid);
        if(index < 0) {
            System.out.println("Resume with uuid " + targetUuid + " does not exist");
        } else {
            storage[index].setUuid(newUuid);
        }
    }

    public final void delete(String uuid) {
        int index = findIndex(uuid);
        if(index < 0) {
            System.out.println("Resume with uuid " + uuid + " does not exist");
        } else {
            fillPosition(index);
            size--;
        }
    }

    protected abstract void fillPosition(int index);

    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected final int findIndex(String uuid) {
        Resume key = new Resume();
        key.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, key);
    }
}
