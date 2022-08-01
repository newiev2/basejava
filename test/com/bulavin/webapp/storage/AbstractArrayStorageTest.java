package com.bulavin.webapp.storage;

import com.bulavin.webapp.exception.ExistsStorageException;
import com.bulavin.webapp.exception.NotExistsStorageException;
import com.bulavin.webapp.exception.StorageException;
import com.bulavin.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractArrayStorageTest {

    private static final int STORAGE_LIMIT = 10000;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);

    private static Storage storage;

    protected AbstractArrayStorageTest(Storage storage) {
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
    public void testGetSize() {
        Assertions.assertEquals(3, storage.getSize());
    }

    @Test
    public void testClear() {
        storage.clear();
        Assertions.assertEquals(0, storage.getSize());
    }

    @Test
    public void testSave() {
        storage.save(RESUME_4);
        Assertions.assertEquals(4, storage.getSize());
        Resume[] resumes = {RESUME_1, RESUME_2, RESUME_3, RESUME_4};
        Assertions.assertArrayEquals(resumes, storage.getAll());
    }

    @Test
    public void testSaveExisted() {
        Assertions.assertThrows(ExistsStorageException.class, () -> {
            Resume resume = new Resume(UUID_1);
            storage.save(resume);
        });
    }

    @Test
    public void testSaveStorageOverflow() {
        storage.clear();
        for (int i = 0; i < STORAGE_LIMIT; i++) {
            storage.save(new Resume());
        }
        Assertions.assertThrows(StorageException.class, () -> storage.save(new Resume()));
    }

    @Test
    public void testGet() {
        Assertions.assertSame(RESUME_1, storage.get("uuid1"));
    }

    @Test
    public void testGetNotExisted() {
        Assertions.assertThrows(NotExistsStorageException.class, () -> storage.get(new Resume().getUuid()));
    }

    @Test
    public void testUpdate() {
        Resume resume = new Resume(UUID_2);
        storage.update(RESUME_2);
        Assertions.assertEquals(resume, storage.get(UUID_2));
    }

    @Test
    public void testUpdateNotExisted() {
        Assertions.assertThrows(NotExistsStorageException.class, () -> storage.update(new Resume()));
    }

    @Test
    public void testDelete() {
        storage.delete("uuid3");
        Assertions.assertEquals(2, storage.getSize());
        Resume[] resumes = {RESUME_1, RESUME_2};
        Assertions.assertArrayEquals(resumes, storage.getAll());
    }

    @Test
    public void testDeleteNotExisted() {
        Assertions.assertThrows(NotExistsStorageException.class, () -> storage.delete(new Resume().getUuid()));
    }

    @Test
    public void testGetAll() {
        Resume[] resumes = {RESUME_1, RESUME_2, RESUME_3};
        Assertions.assertArrayEquals(storage.getAll(), resumes);
    }
}