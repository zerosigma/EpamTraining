package main.java.ru.elena.TravelAgency.v6.Storage.initializer.exception.checked;

import main.java.ru.elena.TravelAgency.v5.Storage.initializer.exception.InitializingDataExceptionMeta;
import main.java.ru.elena.TravelAgency.v5.common.business.exception.BaseTravelAgencyCheckedException;

public class InvalidCountryDiscriminatorException extends BaseTravelAgencyCheckedException {
    public InvalidCountryDiscriminatorException(int code, String message) {
        super(code, message);
    }

    public InvalidCountryDiscriminatorException(InitializingDataExceptionMeta exceptionMeta) {
        super(exceptionMeta.getCode(), exceptionMeta.getDescription());
    }
}
