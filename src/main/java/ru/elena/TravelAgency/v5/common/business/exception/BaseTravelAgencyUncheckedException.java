package main.java.ru.elena.TravelAgency.v5.common.business.exception;

public abstract class BaseTravelAgencyUncheckedException extends RuntimeException {
    protected int code;

    public BaseTravelAgencyUncheckedException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseTravelAgencyUncheckedException(int code, String message, Exception cause) {
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
