package com.bulavin.webapp.model;

import java.util.Objects;

public class TextSection extends Section {

    private final String title;
    private final String content;

    public TextSection(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextSection)) return false;
        TextSection that = (TextSection) o;
        return Objects.equals(title, that.title) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content);
    }

    @Override
    public String toString() {
        return "TextSection{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
