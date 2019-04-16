package main.java.ru.elena.TravelAgency.v2.utils.ArrayUtils;

public class ArrayUtils {
    private ArrayUtils() {
    }

    public static void deleteElement(Object[] array, int index) {
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
    }

    public static void extendArray(Object[] array) {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
