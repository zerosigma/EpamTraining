package ru.elena.TravelAgency.v6.Country.exception.checked;

import ru.elena.TravelAgency.v5.Country.exception.CountryExceptionMeta;
import ru.elena.TravelAgency.v5.common.business.exception.BaseTravelAgencyCheckedException;

public class CountryDeletionException extends BaseTravelAgencyCheckedException {
    public CountryDeletionException(int code, String message) {
        super(code, message);
    }

    public CountryDeletionException(CountryExceptionMeta exceptionMeta) {
        super(exceptionMeta.getCode(), exceptionMeta.getDescription());
    }
}
