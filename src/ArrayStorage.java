import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    public void clear() {
        Arrays.fill(storage,0, size(), null);
    }

    void save(Resume resume) {
        for(int i = 0; i <= size(); i++) {
            if(i == size()) {
                storage[i] = resume;
                break;
            } else if(size() + 1 == storage.length) {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if(storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        throw new IllegalArgumentException("Resume with such uuid does not exist");
    }

    public void delete(String uuid) {
        boolean isSorted = false;
        for(int i = 0; i < size(); i++) {
            if(storage[i].toString().equals(uuid)) {

                // Check if target resume is very last
                if(storage[i + 1] == null) {
                    storage[i] = null;
                    break;
                }

                // Sorting array to fill in "holes"
                for(int j = i; j < size(); j++) {
                    if(j == size() - 1) {
                        storage[j] = null;
                        isSorted = true;
                        break;
                    }
                    storage[j] = storage[j + 1];
                }
                if(isSorted) {
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        for(int i = 0; i < storage.length; i++) {
            if(storage[i] == null) {
                return Arrays.copyOf(storage, i);
            }
        }
        return null;
    }

    public int size() {
        for(int i = 0; i < storage.length; i++) {
            if(storage[i] == null) {
                return i;
            }
        }
        return 0;
    }
}
