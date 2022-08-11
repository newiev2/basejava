package com.bulavin.webapp.storage;

import com.bulavin.webapp.exception.ExistsStorageException;
import com.bulavin.webapp.exception.NotExistsStorageException;
import com.bulavin.webapp.exception.StorageException;
import com.bulavin.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.bulavin.webapp.storage.AbstractArrayStorage.*;

public abstract class AbstractStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);

    private final Storage storage;

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertSameResume(RESUME_4);
    }

    @Test
    public void saveExisting() {
        Assertions.assertThrows(ExistsStorageException.class, () -> {
            Resume resume = new Resume(UUID_1);
            storage.save(resume);
        });
    }

    @Test
    public void saveOverflow() {
        storage.clear();
        for (int i = 0; i < STORAGE_LIMIT; i++) {
            storage.save(new Resume());
        }
        Assertions.assertThrows(StorageException.class, () -> storage.save(new Resume()));
    }

    @Test
    public void get() {
        assertSameResume(RESUME_1);
        assertSameResume(RESUME_2);
        assertSameResume(RESUME_3);
    }

    @Test
    public void getNotExisting() {
        Assertions.assertThrows(NotExistsStorageException.class, () -> storage.get(new Resume().getUuid()));
    }

    @Test
    public void update() {
        Resume resume = new Resume(UUID_2);
        storage.update(resume);
        assertSameResume(resume);
    }

    @Test
    public void updateNotExisting() {
        Assertions.assertThrows(NotExistsStorageException.class, () -> storage.update(new Resume()));
    }

    @Test
    public void delete() {
        storage.delete(UUID_3);
        assertSize(2);
        Resume[] resumes = {RESUME_1, RESUME_2};
        Assertions.assertArrayEquals(resumes, storage.getAll());
    }

    @Test
    public void deleteNotExisting() {
        Assertions.assertThrows(NotExistsStorageException.class, () -> storage.delete(new Resume().getUuid()));
    }

    @Test
    public void getAll() {
        Resume[] resumes = {RESUME_1, RESUME_2, RESUME_3};
        Assertions.assertArrayEquals(resumes, storage.getAll());
    }

    private void assertSize(int expectedNum) {
        Assertions.assertEquals(expectedNum, storage.size());
    }

    private void assertSameResume(Resume resume) {
        Assertions.assertSame(resume, storage.get(resume.getUuid()));
    }
}