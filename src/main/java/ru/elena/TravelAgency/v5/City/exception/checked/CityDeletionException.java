package main.java.ru.elena.TravelAgency.v5.City.exception.checked;

import main.java.ru.elena.TravelAgency.v5.City.exception.CityExceptionMeta;
import main.java.ru.elena.TravelAgency.v5.common.business.exception.BaseTravelAgencyCheckedException;

public class CityDeletionException extends BaseTravelAgencyCheckedException {
    public CityDeletionException(int code, String message) {
        super(code, message);
    }

    public CityDeletionException(CityExceptionMeta exceptionMeta) {
        super(exceptionMeta.getCode(), exceptionMeta.getDescription());
    }
}
