package com.elena.TravelAgency.v5.Country.exception.checked;

import com.elena.TravelAgency.v5.Country.exception.CountryExceptionMeta;
import com.elena.TravelAgency.v5.common.business.exception.BaseTravelAgencyCheckedException;

public class CountryDeletionException extends BaseTravelAgencyCheckedException {
    public CountryDeletionException(int code, String message) {
        super(code, message);
    }

    public CountryDeletionException(CountryExceptionMeta exceptionMeta) {
        super(exceptionMeta.getCode(), exceptionMeta.getDescription());
    }
}
