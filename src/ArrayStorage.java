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
        if(size == storage.length) {
            throw new IndexOutOfBoundsException();
        }
        if(isExisted(resume)) {
            throw new IllegalArgumentException("Resume with such uuid already exists");
        }
        storage[size] = resume;
        size++;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if(storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        throw new IllegalArgumentException("Resume with such uuid does not exist");
    }

    public void delete(String uuid) {
        for(int i = 0; i < size; i++) {
            if(storage[i].toString().equals(uuid)) {
                storage[i] = null;
                sort();
                size--;
                break;
            } else if(!storage[i].toString().equals(uuid) && i == size - 1) {
                throw new IllegalArgumentException("Resume with such uuid does not exist");
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    private void sort() {
        Resume[] storageCopy = Arrays.copyOf(storage, storage.length);
        int count = 1;
        int destIndex = 0;
        int srcIndex;

        for(int i = 0; i < size; i++) {
            if(storageCopy[i] != null) {
                srcIndex = i;
                if(i < size - 1) {
                    for(int j = i + 1; j < size; j++) {
                        if(storageCopy[j] == null) {
                            break;
                        }
                        count++;
                    }
                }
                System.arraycopy(storageCopy, srcIndex, storage, destIndex, count);
                destIndex += count;
                i += count;
                count = 1;
            }
        }
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
