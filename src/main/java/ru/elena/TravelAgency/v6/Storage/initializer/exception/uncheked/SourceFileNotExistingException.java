package main.java.ru.elena.TravelAgency.v6.Storage.initializer.exception.uncheked;

import main.java.ru.elena.TravelAgency.v5.Storage.initializer.exception.InitializingDataExceptionMeta;
import main.java.ru.elena.TravelAgency.v5.common.business.exception.BaseTravelAgencyUncheckedException;

public class SourceFileNotExistingException extends BaseTravelAgencyUncheckedException {
    public SourceFileNotExistingException(int code, String message) {
        super(code, message);
    }

    public SourceFileNotExistingException(InitializingDataExceptionMeta exceptionMeta) {
        super(exceptionMeta.getCode(), exceptionMeta.getDescription());
    }
}
