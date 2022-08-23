package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void saveResume(Resume resume, Object searchKey) {
        storage.put(searchKey.toString(), resume);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return storage.get(searchKey.toString());
    }

    @Override
    protected void updateResume(Resume resume, Object searchKey) {
        storage.put(searchKey.toString(), resume);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        storage.remove(searchKey.toString());
    }

    @Override
    protected boolean isExisting(Object searchKey) {
        return storage.containsKey(searchKey.toString());
    }

    @Override
    protected Resume findSearchKey(String uuid) {
        return new Resume(uuid, null);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected List<Resume> getAllElements() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public int size() {
        return storage.size();
    }
}
