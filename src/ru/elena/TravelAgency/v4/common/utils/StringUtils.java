package ru.elena.TravelAgency.v4.common.utils;

public final class StringUtils {
    private StringUtils() {

    }

    public static boolean isEmptyString(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotEmptyString(String str) {
        return !isEmptyString(str);
    }
}
