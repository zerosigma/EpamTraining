package com.elena.TravelAgency.v5.Storage.initializer.exception.uncheked;

import com.elena.TravelAgency.v5.common.business.exception.BaseTravelAgencyUncheckedException;

public class InvalidXmlDocumentStructureException extends BaseTravelAgencyUncheckedException {

    public InvalidXmlDocumentStructureException(int code, String message) {
        super(code, message);
    }
}
