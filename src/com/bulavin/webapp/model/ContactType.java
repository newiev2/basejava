package com.bulavin.webapp.model;

public enum ContactType {
    PHONE("Тел."),
    SKYPE("Skype"),
    EMAIL("Почта"),
    LINKEDIN("LinkedIn"),
    GITHUB("GitHub"),
    STACKOVERFLOW("Stackoverflow");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
