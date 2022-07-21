/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume resume1 = new Resume();
        resume1.setUuid("uuid1");
        Resume resume2 = new Resume();
        resume2.setUuid("uuid2");
        Resume resume3 = new Resume();
        resume3.setUuid("uuid3");
        Resume resume4 = new Resume();
        resume4.setUuid("uuid4");
        Resume resume5 = new Resume();
        resume5.setUuid("uuid5");
        Resume resume6 = new Resume();
        resume6.setUuid("uuid6");

        try {
            ARRAY_STORAGE.save(resume1);
            ARRAY_STORAGE.save(resume2);
            ARRAY_STORAGE.save(resume3);
            ARRAY_STORAGE.save(resume4);
            ARRAY_STORAGE.save(resume5);
            ARRAY_STORAGE.save(resume6);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Array capacity is full. In order to save resume you should delete at least one");
        }

        System.out.println("Get resume3: " + ARRAY_STORAGE.get("uuid3"));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        try {
            System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        printAll();
        ARRAY_STORAGE.delete("uuid4");
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
