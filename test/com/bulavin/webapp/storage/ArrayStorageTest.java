package com.bulavin.webapp.storage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStorageTest extends AbstractArrayStorageTest {

    ArrayStorageTest() {
        super(new ArrayStorage());
    }

    @Test
    public void testGetSize() {
        super.testGetSize();
    }

    @Test
    public void testClear() {
        super.testClear();
    }

    @Test
    public void testSave() {
        super.testSave();
    }

    @Test
    public void testSaveExisted() {
        super.testSaveExisted();
    }

    @Test
    public void testSaveStorageOverflow() {
        super.testSaveStorageOverflow();
    }

    @Test
    public void testGet() {
        super.testGet();
    }

    @Test
    public void testGetNotExisted() {
        super.testGetNotExisted();
    }

    @Test
    public void testUpdate() {
        super.testUpdate();
    }

    @Test
    public void testUpdateNotExisted() {
        super.testUpdateNotExisted();
    }

    @Test
    public void testDelete() {
        super.testDelete();
    }

    @Test
    public void testDeleteNotExisted() {
        super.testDeleteNotExisted();
    }

    @Test
    public void testGetAll() {
        super.testGetAll();
    }
}