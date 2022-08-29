package com.bulavin.webapp.storage;

import com.bulavin.webapp.exception.ExistsStorageException;
import com.bulavin.webapp.exception.NotExistsStorageException;
import com.bulavin.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    protected final static Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName)
            .thenComparing(Resume::getUuid);
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    public final void save(Resume resume) {
        LOG.info("Save " + resume);
        SK searchKey = getNotExistingSearchKey(resume.getUuid());
        saveResume(resume, searchKey);
    }

    public final Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getExistingSearchKey(uuid);
        return getResume(searchKey);
    }

    public final void update(Resume resume) {
        LOG.info("Update " + resume);
        SK searchKey = getExistingSearchKey(resume.getUuid());
        updateResume(resume, searchKey);
    }

    public final void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = getExistingSearchKey(uuid);
        deleteResume(searchKey);

    }

    public final List<Resume> getAllSorted() {
        LOG.info("Get all sorted");
        List<Resume> resumeList = getAllElements();
        resumeList.sort(RESUME_COMPARATOR);
        return resumeList;
    }

    private SK getNotExistingSearchKey(String uuid) {
        SK searchKey = findSearchKey(uuid);
        if (isExisting(searchKey)) {
            LOG.warning("Resume with uuid " + uuid + " already exists");
            throw new ExistsStorageException(uuid);
        }
        return searchKey;
    }

    private SK getExistingSearchKey(String uuid) {
        SK searchKey = findSearchKey(uuid);
        if (!isExisting(searchKey)) {
            LOG.warning("Resume with uuid " + uuid + " does not exist");
            throw new NotExistsStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract void saveResume(Resume resume, SK searchKey);

    protected abstract Resume getResume(SK searchKey);

    protected abstract void updateResume(Resume resume, SK searchKey);

    protected abstract void deleteResume(SK searchKey);

    protected abstract List<Resume> getAllElements();

    protected abstract boolean isExisting(SK searchKey);

    protected abstract SK findSearchKey(String uuid);
}
