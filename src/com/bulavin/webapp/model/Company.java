package com.bulavin.webapp.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Company {

    private final String name;
    private final String website;
    private final List<Period> periods;

    public Company(String name, String website, Period...periods) {
        this.name = name;
        this.website = website;
        this.periods = Arrays.asList(periods);
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(website, company.website)
                && Objects.equals(periods, company.periods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, website, periods);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", periods=" + periods +
                '}';
    }

    public static class Period {

        private final LocalDate fromDate;
        private final LocalDate endDate;
        private final String position;
        private final String description;

        public Period(LocalDate fromDate, LocalDate endDate, String position, String description) {
            this.fromDate = fromDate;
            this.endDate = endDate;
            this.position = position;
            this.description = description;
        }

        public LocalDate getFromDate() {
            return fromDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public String getPosition() {
            return position;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Period)) return false;
            Period period = (Period) o;
            return Objects.equals(fromDate, period.fromDate) && Objects.equals(endDate, period.endDate)
                    && Objects.equals(position, period.position) && Objects.equals(description, period.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fromDate, endDate, position, description);
        }

        @Override
        public String toString() {
            return "Period{" +
                    "fromDate='" + fromDate + '\'' +
                    ", endDate='" + endDate + '\'' +
                    ", position='" + position + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
