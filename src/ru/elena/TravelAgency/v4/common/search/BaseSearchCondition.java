package ru.elena.TravelAgency.v4.common.search;

public class BaseSearchCondition {
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean searchById() {
        return id != null;
    }
}
