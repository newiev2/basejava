package com.bulavin.webapp.storage;

import com.bulavin.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

    private final List<Resume> storage = new ArrayList<>();

    @Override
    protected void saveResume(Resume resume, Integer index) {
        storage.add(resume);
    }

    @Override
    protected Resume getResume(Integer index) {
        return storage.get(index);
    }

    @Override
    protected void updateResume(Resume resume, Integer index) {
        storage.set(index, resume);
    }

    @Override
    protected void deleteResume(Integer index) {
        storage.remove((index).intValue());
    }

    @Override
    protected List<Resume> getAllElements() {
        return storage;
    }

    @Override
    protected boolean isExisting(Integer index) {
        return index >= 0;
    }

    @Override
    protected Integer findSearchKey(String uuid) {
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
