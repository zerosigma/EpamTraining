package main.java.ru.elena.TravelAgency.v5.common.business.dto;

public abstract class BaseDTO<ID_TYPE> {
    protected ID_TYPE id;

    public ID_TYPE getId() {
        return id;
    }

    public void setId(ID_TYPE id) {
        this.id = id;
    }
}
