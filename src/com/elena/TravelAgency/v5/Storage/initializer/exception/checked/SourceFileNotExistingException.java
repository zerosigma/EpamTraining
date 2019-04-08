package com.elena.TravelAgency.v5.Storage.initializer.exception.checked;

import com.elena.TravelAgency.v5.common.business.exception.BaseTravelAgencyCheckedException;

public class SourceFileNotExistingException extends BaseTravelAgencyCheckedException {

    public SourceFileNotExistingException(int code, String message) {
        super(code, message);
    }
}
