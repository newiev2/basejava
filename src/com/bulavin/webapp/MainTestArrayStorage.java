package com.bulavin.webapp;

import com.bulavin.webapp.model.Resume;
import com.bulavin.webapp.storage.AbstractArrayStorage;
import com.bulavin.webapp.storage.SortedArrayStorage;

/**
 * Test for your com.bulavin.webapp.storage.storage implementation
 */
public class MainTestArrayStorage {
    private static final AbstractArrayStorage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume resume1 = new Resume("uuid7");
        Resume resume2 = new Resume("uuid3");
        Resume resume3 = new Resume("uuid5");
        Resume resume4 = new Resume("uuid2");
        Resume resume5 = new Resume("uuid9");

        ARRAY_STORAGE.save(resume1);
        ARRAY_STORAGE.save(resume2);
        ARRAY_STORAGE.save(resume3);
        ARRAY_STORAGE.save(resume4);
        ARRAY_STORAGE.save(resume5);

        ARRAY_STORAGE.update(resume1);
        System.out.println("Get resume3: " + ARRAY_STORAGE.get("uuid18"));
        System.out.println("Size: " + ARRAY_STORAGE.size());
        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete("uuid1");
        System.out.println("Get resume9: " + ARRAY_STORAGE.get("uuid9"));
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for(Resume resume : ARRAY_STORAGE.getAll()) {
            System.out.println(resume);
        }
    }
}
