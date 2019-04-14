package ru.elena.TravelAgency.v3.common.utils;

public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static void deleteElement(Object[] array, int index) {
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
    }
}
