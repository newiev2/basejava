package com.bulavin.webapp.model;

import java.util.List;
import java.util.Objects;

public class CompanySection extends Section {

    private final String title;
    private final List<Company> companies;

    public CompanySection(String title, List<Company> companies) {
        this.title = title;
        this.companies = companies;
    }

    public String getTitle() {
        return title;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanySection)) return false;
        CompanySection that = (CompanySection) o;
        return Objects.equals(title, that.title) && Objects.equals(companies, that.companies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, companies);
    }

    @Override
    public String toString() {
        return "CompanySection{" +
                "title='" + title + '\'' +
                ", periods=" + companies +
                '}';
    }
}
