package com.bulavin.webapp.storage;

import com.bulavin.webapp.exception.StorageException;
import com.bulavin.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {

    private final File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "Directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected void saveResume(Resume resume, File searchKey) {
        try {
            searchKey.createNewFile();
            writeData(resume, searchKey);
        } catch (IOException e) {
            throw new StorageException(searchKey.getName(), "Error occurred while trying to save resume", e);
        }
    }

    @Override
    protected Resume getResume(File searchKey) {
        try {
            return readData(searchKey);
        } catch (IOException e) {
            throw new StorageException(searchKey.getName(), "Error occurred while trying to get resume", e);
        }
    }

    @Override
    protected void updateResume(Resume resume, File searchKey) {
        try {
            writeData(resume, searchKey);
        } catch (IOException e) {
            throw new StorageException(searchKey.getName(), "Error occurred while trying to update resume", e);
        }
    }

    @Override
    protected void deleteResume(File searchKey) {
        if (!searchKey.delete()) {
            throw new StorageException(searchKey.getName(), "Error occurred while trying to delete resume");
        }
    }

    @Override
    protected List<Resume> getAllElements() {
        File[] files = directory.listFiles();
        if (files != null) {
            List<Resume> resumes = new ArrayList<>();
            for (File file : files) {
                resumes.add(getResume(file));
            }
            return resumes;
        } else throw new StorageException("Error occurred while trying to get all resumes");
    }

    @Override
    protected boolean isExisting(File searchKey) {
        return searchKey.exists();
    }

    @Override
    protected File findSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                deleteResume(file);
            }
        } else throw new StorageException("Directory is empty. Nothing to clear");
    }

    @Override
    public int size() {
        File[] files = directory.listFiles();
        if (files != null) {
            return files.length;
        }
        return 0;
    }

    protected abstract void writeData(Resume resume, File file) throws IOException;

    protected abstract Resume readData(File file) throws IOException;
}
