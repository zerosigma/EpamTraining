package ru.elena.TravelAgency.v5.common.business.domain;

public abstract class BaseDomain<ID_TYPE> {
    protected ID_TYPE id;

    public ID_TYPE getId() {
        return id;
    }

    public void setId(ID_TYPE id) {
        this.id = id;
    }
}
