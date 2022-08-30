package com.bulavin.webapp.model;

import java.util.Objects;

public class Period {

    private final String fromDate;
    private final String endDate;
    private final String position;
    private final String description;

    public Period(String fromDate, String endDate, String position, String description) {
        this.fromDate = fromDate;
        this.endDate = endDate;
        this.position = position;
        this.description = description;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getEndDate() {
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
