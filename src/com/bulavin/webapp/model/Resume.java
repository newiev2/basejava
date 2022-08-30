package com.bulavin.webapp.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume {

    private final String uuid;
    private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private final Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);
    private final String fullName;

    public Resume() {
        this(UUID.randomUUID().toString());
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContact(ContactType type) {
        return contacts.get(type);
    }

    public void setContact(ContactType type, String contact) {
        contacts.put(type, contact);
    }

    public Section getSection(SectionType type) {
        return sections.get(type);
    }

    public void setSection(SectionType type, Section section) {
        sections.put(type, section);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume)) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) && Objects.equals(contacts, resume.contacts) && Objects.equals(sections, resume.sections) && Objects.equals(fullName, resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, contacts, sections, fullName);
    }

    @Override
    public String toString() {
        return "Resume{" +
                "uuid='" + uuid + '\'' +
                ", contacts=" + contacts +
                ", sections=" + sections +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
