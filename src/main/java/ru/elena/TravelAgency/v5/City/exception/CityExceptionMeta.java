package main.java.ru.elena.TravelAgency.v5.City.exception;

public enum CityExceptionMeta {
    CITY_DELETION_CONSTRAINT_ERROR(1, "Constraint violation. " +
                                                     "You can't delete the city while it is used.");

    private int code;
    private String description;

    CityExceptionMeta(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
