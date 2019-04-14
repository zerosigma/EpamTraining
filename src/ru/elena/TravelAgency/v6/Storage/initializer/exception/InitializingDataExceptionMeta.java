package ru.elena.TravelAgency.v6.Storage.initializer.exception;

public enum InitializingDataExceptionMeta {
    SOURCE_FILE_NOT_FOUND_ERROR(1, "Such source file doesn't exist."),
    PARSE_COUNTRY_DISCRIMINATOR_ERROR(2, "Unknown country discriminator."),
    XML_END_TAG_NOT_FOUND_ERROR(3, "Can't find suitable end tag.")
    ;

    private int code;
    private String description;

    InitializingDataExceptionMeta(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
