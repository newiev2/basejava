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
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public final void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("Storage is out of capacity");
        } else if (index >= 0) {
            System.out.println("Resume with uuid " + resume + " already exists");
        } else {
            addElement(resume, index);
            size++;
        }
    }

    public final Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Resume with uuid " + uuid + " does not exist");
            return null;
        }
        return storage[index];
    }

    public final void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("Resume with uuid " + resume.getUuid() + " does not exist");
        } else {
            storage[index] = resume;
        }
    }

    public final void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Resume with uuid " + uuid + " does not exist");
        } else {
            fillPosition(index);
            size--;
        }
    }

    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract void addElement(Resume resume, int index);

    protected abstract void fillPosition(int index);

    protected abstract int findIndex(String uuid);
}
