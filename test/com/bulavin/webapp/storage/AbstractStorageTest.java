package com.bulavin.webapp.storage;

import com.bulavin.webapp.exception.ExistsStorageException;
import com.bulavin.webapp.exception.NotExistsStorageException;
import com.bulavin.webapp.model.Resume;
import com.bulavin.webapp.model.ResumeTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.bulavin.webapp.storage.AbstractStorage.RESUME_COMPARATOR;

public abstract class AbstractStorageTest {

    private static final ResumeTestData RESUME_TEST_DATA = new ResumeTestData();
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_1 = RESUME_TEST_DATA.getMockResume(UUID_1, "Nikita");
    private static final Resume RESUME_2 = RESUME_TEST_DATA.getMockResume(UUID_2, "Andrey");
    private static final Resume RESUME_3 = RESUME_TEST_DATA.getMockResume(UUID_3, "Pavel");
    private static final Resume RESUME_4 = RESUME_TEST_DATA.getMockResume(UUID_4, "Nikita");

    protected final Storage storage;

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
        Assertions.assertThrows(ExistsStorageException.class, () -> storage.save(new Resume(UUID_1, null)));
    }

    @Test
    public void get() {
        assertSameResume(RESUME_1);
        assertSameResume(RESUME_2);
        assertSameResume(RESUME_3);
    }

    @Test
    public void getNotExisting() {
        assertNotExisting(new Resume().getUuid());
    }

    @Test
    public void update() {
        Resume resume = new Resume(UUID_2, "Pavel");
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
        assertNotExisting(UUID_3);
    }

    @Test
    public void deleteNotExisting() {
        Assertions.assertThrows(NotExistsStorageException.class, () -> storage.delete(new Resume().getUuid()));
    }

    @Test
    public void getAllSorted() {
        List<Resume> resumeList = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);
        resumeList.sort(RESUME_COMPARATOR);
        Assertions.assertEquals(resumeList, storage.getAllSorted());
    }

    private void assertSize(int expectedNum) {
        Assertions.assertEquals(expectedNum, storage.size());
    }

    private void assertSameResume(Resume resume) {
        Assertions.assertSame(resume, storage.get(resume.getUuid()));
    }

    private void assertNotExisting(String uuid) {
        Assertions.assertThrows(NotExistsStorageException.class,
                () -> storage.get(new Resume(uuid, null).getUuid()));
    }
}