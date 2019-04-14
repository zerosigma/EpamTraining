package ru.elena.TravelAgency.v5.common.business.exception;

public abstract class BaseTravelAgencyCheckedException extends Exception {
    protected int code;

    public BaseTravelAgencyCheckedException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseTravelAgencyCheckedException(int code, String message, Exception cause) {
        super(message);
        this.code = code;
        initCause(cause);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
