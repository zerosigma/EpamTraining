package com.elena.TravelAgency.v1.utils.ArrayUtils;

public class ArrayUtils {
    private ArrayUtils() {
    }

    public static void deleteElement(Object[] array, int index) {
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
    }
}
