import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public int getSize() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage,0, size, null);
        size = 0;
    }

    void save(Resume resume) {
        if(isExisted(resume)) {
            System.out.println("Resume with such uuid already exists in storage");
        }
        if(size == storage.length) {
            System.out.println("Storage is out of capacity");
        }
        if(size < storage.length && !isExisted(resume)) {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if(storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for(int i = 0; i < size; i++) {
            if(storage[i].toString().equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            } else if(!storage[i].toString().equals(uuid) && i == size - 1) {
                System.out.println("Resume with such uuid does not exist");
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    private boolean isExisted(Resume resume) {
        for(int i = 0; i < size; i++) {
            if(storage[i].toString().equals(resume.toString())) {
                return true;
            }
        }
        return false;
    }
}
