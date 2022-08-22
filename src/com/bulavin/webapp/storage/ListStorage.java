package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> storage = new ArrayList<>();

    @Override
    protected void saveResume(Resume resume, Object index) {
        storage.add(resume);
    }

    @Override
    protected Resume getResume(Object index) {
        return storage.get((Integer) index);
    }

    @Override
    protected void updateResume(Resume resume, Object index) {
        storage.set((Integer) index, resume);
    }

    @Override
    protected void deleteResume(Object index) {
        storage.remove(((Integer) index).intValue());
    }

    @Override
    protected List<Resume> getAllElements() {
        return storage;
    }

    @Override
    protected boolean isExisting(Object index) {
        return (Integer) index >= 0;
    }

    @Override
    protected Object findSearchKey(String uuid) {
        for(int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }
}
