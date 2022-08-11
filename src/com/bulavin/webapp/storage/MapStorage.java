package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private final Map<Object, Resume> storage = new HashMap<>();

    @Override
    protected void saveResume(Resume resume, Object searchKey) {
        storage.put(searchKey, resume);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected void updateResume(Resume resume, Object searchKey) {
        storage.put(searchKey, resume);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        storage.remove(searchKey);
    }

    @Override
    protected boolean isExisting(Object searchKey) {
        return storage.containsKey(searchKey);
    }

    @Override
    protected Object findSearchKey(String uuid) {
        return uuid;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = storage.values().toArray(new Resume[0]);
        Arrays.sort(resumes);
        return resumes;
    }

    @Override
    public int size() {
        int size = 0;
        for (Object key: storage.keySet()) {
            size++;
        }
        return size;
    }
}
