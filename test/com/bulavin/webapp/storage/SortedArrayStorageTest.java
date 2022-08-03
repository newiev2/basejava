package com.bulavin.webapp.storage;

import org.junit.jupiter.api.Test;

class SortedArrayStorageTest extends AbstractArrayStorageTest {

    SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Test
    public void testGetSize() {
        super.size();
    }

    @Test
    public void testClear() {
        super.clear();
    }

    @Test
    public void testSave() {
        super.save();
    }

    @Test
    public void testSaveExisting() {
        super.saveExisting();
    }

    @Test
    public void testSaveOverflow() {
        super.saveOverflow();
    }

    @Test
    public void testGet() {
        super.get();
    }

    @Test
    public void testGetNotExisting() {
        super.getNotExisting();
    }

    @Test
    public void testUpdate() {
        super.update();
    }

    @Test
    public void testUpdateNotExisting() {
        super.updateNotExisting();
    }

    @Test
    public void testDelete() {
        super.delete();
    }

    @Test
    public void testDeleteNotExisting() {
        super.deleteNotExisting();
    }

    @Test
    public void testGetAll() {
        super.getAll();
    }
}