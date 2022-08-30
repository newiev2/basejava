package com.bulavin.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListSection extends Section {

    private final String title;
    private final List<String> contents;

    public ListSection(String title, List<String> contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getContents() {
        return contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListSection)) return false;
        ListSection that = (ListSection) o;
        return Objects.equals(title, that.title) && Objects.equals(contents, that.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, contents);
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "title='" + title + '\'' +
                ", contents=" + contents +
                '}';
    }
}
