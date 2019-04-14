package com.elena.TravelAgency.v5.Country.exception;

public enum CountryExceptionMeta {
    COUNTRY_DELETION_CONSTRAINT_ERROR(1, "Constraint violation. " +
                                                        "You can't delete the country while it is used.");

    private int code;
    private String description;

    CountryExceptionMeta(int code, String description) {
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
